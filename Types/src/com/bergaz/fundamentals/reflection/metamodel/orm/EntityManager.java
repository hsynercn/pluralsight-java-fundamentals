package com.bergaz.fundamentals.reflection.metamodel.orm;

import java.sql.SQLException;

public class EntityManager<T> {
    public static <T> EntityManager<T> of(Class<T> class1) {
        return new EntityManagerImp<>();
    }

    public void persist(T t) throws SQLException, IllegalAccessException {
    }
}
