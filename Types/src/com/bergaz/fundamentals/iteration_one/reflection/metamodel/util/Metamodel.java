package com.bergaz.fundamentals.iteration_one.reflection.metamodel.util;

import com.bergaz.fundamentals.iteration_one.reflection.metamodel.annotation.Column;
import com.bergaz.fundamentals.iteration_one.reflection.metamodel.annotation.PrimaryKey;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Metamodel {

    private Class<?> clss;

    public static Metamodel of(Class<?> clss) {
        return new Metamodel(clss);
    }

    public Metamodel(Class<?> clss) {
        this.clss = clss;
    }

    public PrimaryKeyField getPrimaryKey() {
        Field[]fields = clss.getDeclaredFields();
        for (Field field : fields) {
            PrimaryKey primaryKey = field.getAnnotation(PrimaryKey.class);
            if (primaryKey != null) {
                PrimaryKeyField primaryKeyField = new PrimaryKeyField(field);
                return primaryKeyField;
            }
        }
        throw new IllegalArgumentException("No primary key found in class: " + clss.getSimpleName());
    }

    public List<ColumnField> getColumns() {
        List<ColumnField> columnFields = new ArrayList<>();
        Field[]fields = clss.getDeclaredFields();
        for (Field field : fields) {
            Column column = field.getAnnotation(Column.class);
            if (column != null) {
                ColumnField columnField = new ColumnField(field);
                columnFields.add(columnField);
            }
        }
        return columnFields;
    }

    public String buildInsertRequest() {
        String columnElement = buildColumnName();

        String questionMarksElement = buildQuestionMarksElement();

        return "insert into " + this.clss.getSimpleName() +
                "(" + columnElement + ") values (" + questionMarksElement + ")";
    }

    public String buildSelectRequest() {
        String columnElement = buildColumnName();
        return "select " + columnElement + " from " + this.clss.getSimpleName() +
                " where " + getPrimaryKey().getName() + "= ?";
    }

    private String buildQuestionMarksElement() {
        int numberOfColumns = getColumns().size() + 1;
        return IntStream.range(0, numberOfColumns).
                mapToObj(index -> "?" ).
                collect(Collectors.joining(", "));
    }

    private String buildColumnName() {
        String primaryKeyColumnName = getPrimaryKey().getName();
        List<String> columnNames = getColumns().stream().map(c -> c.getName()).collect(Collectors.toList());
        columnNames.add(0, primaryKeyColumnName);
        return String.join(", ", columnNames);
    }
}
