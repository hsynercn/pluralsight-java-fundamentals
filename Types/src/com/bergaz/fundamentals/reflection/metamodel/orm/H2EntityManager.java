package com.bergaz.fundamentals.reflection.metamodel.orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class H2EntityManager<T> extends AbstractEntityManager<T> {
    public PreparedStatement buildConnection(String sql) throws SQLException {
        Connection connection =
                DriverManager.getConnection(
                        "jdbc:h2:C:/Pluralsight/pluralsight-java-fundamentals/Types/db-files/db-pluralsight",
                        "sa", "");
        return connection.prepareStatement(sql);
    }
}
