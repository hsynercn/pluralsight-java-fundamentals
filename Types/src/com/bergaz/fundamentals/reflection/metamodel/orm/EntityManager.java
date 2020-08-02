package com.bergaz.fundamentals.reflection.metamodel.orm;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface EntityManager<T> {
    public static <T> EntityManager<T> of(Class<T> class1) {
        return new H2EntityManager<>();
    }

    public void persist(T t) throws SQLException, IllegalAccessException;

    public T find(Class<T> clss, Object primaryKey) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
}
