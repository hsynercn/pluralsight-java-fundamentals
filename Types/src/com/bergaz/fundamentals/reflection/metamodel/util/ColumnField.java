package com.bergaz.fundamentals.reflection.metamodel.util;

import com.bergaz.fundamentals.reflection.metamodel.annotation.Column;

import java.lang.reflect.Field;

public class ColumnField {
    private Field field;
    private Column column;
    public ColumnField(Field field) {
        this.field = field;
        this.column = field.getAnnotation(Column.class);
    }

    public Class<?> getType() {
        return field.getType();
    }

    public String getName() {
        return column.name();
    }

    public Field getField() {
        return field;
    }
}
