package com.bergaz.fundamentals.reflection;

public class Main {
    public static void main(String[] args) {
        //First way to get reference on a class object
        String hello = "Hello";
        Class helloClass = hello.getClass();

        String world = "World";
        Class worldClass = world.getClass();

        if(helloClass == worldClass) {
            System.out.println("hello and world classes are equal");
        }

        Integer x = 0, y = 11;
        Class xClass = x.getClass();
        Class yClass = y.getClass();

        if(xClass == yClass) {
            System.out.println("x and y classes are equal");
        }

        Boolean flag = false;
        Class<? extends Boolean> flagClass = flag.getClass();
        Class flagClass1 = flag.getClass();

        //Second way of getting reference on a class object
        Class<?> stringClass = String.class;

        //Third way of getting reference on a class object
        String className = "java.lang.String";
        try {
            Class<?> stringClass1 = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
