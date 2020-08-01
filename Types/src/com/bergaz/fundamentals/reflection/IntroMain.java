package com.bergaz.fundamentals.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class IntroMain {
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

        Class<?> aClass = "Hello".getClass();

        Class<?> superClass = aClass.getSuperclass();
        Class<?>[] interfaces = aClass.getInterfaces();


        Class<?> clssTmp = Person.class;

        try {
            Field field = clssTmp.getField("age");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        Field[] fields = clssTmp.getFields();
        Field[] declaredFields = clssTmp.getDeclaredFields();

        try {
            Method method = clssTmp.getMethod("setName", String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        Method[] declaredMethods = clssTmp.getDeclaredMethods();
        Method[] methods = clssTmp.getMethods();
    }
}
