package com.bergaz.fundamentals.core.annotations;

public class SomeClass {
    private int value;
    private String name;

    public SomeClass(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "This is a fancy string";
    }
}
