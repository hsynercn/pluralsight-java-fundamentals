package com.bergaz.fundamentals.iteration_one.reflection.metamodel;

import com.bergaz.fundamentals.iteration_one.reflection.metamodel.beanmanager.BeanManager;
import com.bergaz.fundamentals.iteration_one.reflection.metamodel.model.Person;
import com.bergaz.fundamentals.iteration_one.reflection.metamodel.orm.EntityManager;
import com.bergaz.fundamentals.iteration_one.reflection.metamodel.orm.ManagedEntityManager;

import java.sql.SQLException;

public class WritingObjects {
    public static void main(String[] args) throws SQLException, IllegalAccessException {

        BeanManager beanManager = BeanManager.getInstance();
        EntityManager<Person> entityManager = beanManager.getInstance(ManagedEntityManager.class);

        Person linda = new Person("Linda", 31);
        Person james = new Person("James", 24);
        Person susan = new Person("Susan", 34);
        Person john = new Person("John", 34);

        entityManager.persist(linda);
        entityManager.persist(james);
        entityManager.persist(susan);
        entityManager.persist(john);
    }
}
