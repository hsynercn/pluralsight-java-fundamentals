package com.bergaz.fundamentals.iteration_one.reflection.metamodel.model;

import com.bergaz.fundamentals.iteration_one.reflection.metamodel.annotation.Column;
import com.bergaz.fundamentals.iteration_one.reflection.metamodel.annotation.PrimaryKey;

public class Person {

    @PrimaryKey(name="k_id")
    private long id;
    @Column(name="c_age")
    private int age;
    @Column(name="c_name")
    private String name;

    public Person() {
    }

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public static Person of(String name, int age) {
        return new Person(name, age);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
