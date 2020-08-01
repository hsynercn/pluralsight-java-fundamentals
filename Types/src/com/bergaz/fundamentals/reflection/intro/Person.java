package com.bergaz.fundamentals.reflection.intro;

public class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person() {
    }

    private void hiddenMethod() {
        System.out.println("Print hidden thing.");
    }

    public static Person of(int age, String name) {
        return new Person(age, name);
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

    @Override
    public String toString() {
        return "{ age: " + age + " name: " + name + " }";
    }
}
