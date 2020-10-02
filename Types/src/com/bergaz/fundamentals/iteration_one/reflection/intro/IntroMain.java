package com.bergaz.fundamentals.iteration_one.reflection.intro;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class IntroMain {
    public static void main(String[] args) {

        String classString = "com.bergaz.fundamentals.iteration_one.reflection.intro.Person";

        try {
            printClassInfo(classString);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printClassInfo(String className) throws ClassNotFoundException {
        Class<?> tmpClass = Class.forName(className);
        System.out.println("PRINT CLASS INFORMATION:");
        System.out.println("Class: " + tmpClass);

        Field[] fields = tmpClass.getFields();
        System.out.println("Fields:");
        System.out.println(Arrays.toString(fields));

        Field[] declaredFields = tmpClass.getDeclaredFields();
        System.out.println("Declared Fields:");
        System.out.println(Arrays.toString(declaredFields));

        Method[] methods = tmpClass.getMethods();
        System.out.println("Methods:");
        for (Method method : methods) {
            System.out.println(method);
        }

        Method[] declaredMethods = tmpClass.getDeclaredMethods();
        System.out.println("Declared Methods:");
        for (Method method : declaredMethods) {
            System.out.println(method);
        }

        System.out.println("Static Declared Methods:");
        Arrays.stream(declaredMethods)
                .filter(m -> Modifier.isStatic(m.getModifiers()))
                .forEach(System.out::println);

    }

    private static void playWithReflection() {
        //First way to get reference on a class object
        String hello = "Hello";
        Class helloClass = hello.getClass();

        String world = "World";
        Class worldClass = world.getClass();

        if (helloClass == worldClass) {
            System.out.println("hello and world classes are equal");
        }

        Integer x = 0, y = 11;
        Class xClass = x.getClass();
        Class yClass = y.getClass();

        if (xClass == yClass) {
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

        try {
            Constructor constructor = clssTmp.getConstructor(Integer.class, String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        Constructor[] declaredConstructors = clssTmp.getDeclaredConstructors();

        //IMPORTANT: Super class constructors are not included, different from getFields and getMethods
        Constructor[] constructors = clssTmp.getConstructors();

        try {
            Field field = clssTmp.getField("name");
            int modifiers = field.getModifiers();
            boolean isPublic = (modifiers & 0x00000001) > 0;
            isPublic = Modifier.isPublic(modifiers);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
