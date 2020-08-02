package com.bergaz.fundamentals.reflection.metamodel.model;

import com.bergaz.fundamentals.reflection.metamodel.annotation.Column;
import com.bergaz.fundamentals.reflection.metamodel.annotation.PrimaryKey;

public class Person {

    @PrimaryKey
    private long id;
    @Column
    private int age;
    @Column
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
