package com.bergaz.fundamentals.iteration_one.reflection.metamodel.orm;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface EntityManager<T> {

    public void persist(T t) throws SQLException, IllegalAccessException;

    public T find(Class<T> clss, Object primaryKey) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
}
