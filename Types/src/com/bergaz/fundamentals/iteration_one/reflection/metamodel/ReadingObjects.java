package com.bergaz.fundamentals.iteration_one.reflection.metamodel;

import com.bergaz.fundamentals.iteration_one.reflection.metamodel.beanmanager.BeanManager;
import com.bergaz.fundamentals.iteration_one.reflection.metamodel.model.Person;
import com.bergaz.fundamentals.iteration_one.reflection.metamodel.orm.EntityManager;
import com.bergaz.fundamentals.iteration_one.reflection.metamodel.orm.ManagedEntityManager;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class ReadingObjects {
    public static void main(String[] args) throws SQLException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        BeanManager beanManager = BeanManager.getInstance();
        EntityManager<Person> entityManager = beanManager.getInstance(ManagedEntityManager.class);

        Person linda = entityManager.find(Person.class, 1L);
        Person james = entityManager.find(Person.class, 2L);
        Person susan = entityManager.find(Person.class, 3L);
        Person john = entityManager.find(Person.class, 4L);
    }
}
