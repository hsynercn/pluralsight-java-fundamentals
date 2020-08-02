package com.bergaz.fundamentals.reflection.metamodel.orm;

import com.bergaz.fundamentals.reflection.metamodel.util.ColumnField;
import com.bergaz.fundamentals.reflection.metamodel.util.Metamodel;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;

public class EntityManagerImp<T> extends EntityManager<T> {

    private AtomicLong idGenerator = new AtomicLong(0L);

    public void persist(T t) throws SQLException, IllegalAccessException {
        Metamodel metamodel = Metamodel.of(t.getClass());
        String sql = metamodel.buildInsertRequest();
        PreparedStatement statement = prepareStatementWith(sql).andParameters(t);
        statement.executeUpdate();
    }

    private PrepareStatementWrapper prepareStatementWith(String sql) throws SQLException {
        Connection connection =
                DriverManager.getConnection(
                        "jdbc:h2:C:/Pluralsight/pluralsight-java-fundamentals/Types/db-files/db-pluralsight",
                        "sa", "");
        PreparedStatement statement = connection.prepareStatement(sql);
        return new PrepareStatementWrapper(statement);
    }

    private class PrepareStatementWrapper {

        private PreparedStatement statement;

        public PrepareStatementWrapper(PreparedStatement statement) {
            this.statement = statement;
        }

        public PreparedStatement andParameters(T t) throws SQLException, IllegalAccessException {
            Metamodel metamodel = Metamodel.of(t.getClass());
            Class<?> primaryKeyType = metamodel.getPrimaryKey().getType();
            if (primaryKeyType == long.class) {
                long id = idGenerator.incrementAndGet();
                statement.setLong(1, id);
                Field field = metamodel.getPrimaryKey().getField();
                field.setAccessible(true);
                field.set(t, id);

            }
            for (int columnIndex = 0; columnIndex < metamodel.getColumns().size(); columnIndex++) {
                ColumnField columnField = metamodel.getColumns().get(columnIndex);
                Class<?> fieldType = columnField.getType();
                Field field = columnField.getField();
                field.setAccessible(true);
                Object value = field.get(t);
                if (fieldType == int.class) {
                    statement.setInt(columnIndex + 2, (int)value);
                } else if (fieldType == String.class) {
                    statement.setString(columnIndex + 2, (String) value);
                }
            }
            return statement;
        }
    }
}
