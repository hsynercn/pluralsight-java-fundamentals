package com.bergaz.fundamentals.iteration_one.reflection.metamodel.util;

import com.bergaz.fundamentals.iteration_one.reflection.metamodel.annotation.PrimaryKey;

import java.lang.reflect.Field;

public class PrimaryKeyField {
    private Field field;
    private PrimaryKey primaryKey;
    public PrimaryKeyField(Field field) {
        this.field = field;
        this.primaryKey = field.getAnnotation(PrimaryKey.class);
    }

    public Class<?> getType() {
        return field.getType();
    }

    public String getName() {
        return primaryKey.name();
    }

    public Field getField() {
        return field;
    }
}
