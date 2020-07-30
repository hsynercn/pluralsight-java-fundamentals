package com.bergaz.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("1", 100);
        //doWork(account);
        BankAccount account1 = new HighVolumeAccount("1", 300);
        //classInfo(account1);
        //typeModifiers(account1);
        fieldInfo(account);
        methodInfo(account1);
        methodInfoInDetail(account1);
    }

    public static void showName(Class<?> theClass) {
        System.out.println("**" + theClass.getSimpleName());
        System.out.println(theClass.getName());
        System.out.println(theClass.getCanonicalName());
        System.out.println(theClass.getConstructors());
        System.out.println(theClass.getDeclaredFields());
    }

    public static void doWork(Object obj) {
        Class<?> c = obj.getClass();
        showName(c);
    }

    public static void classInfo(Object obj) {
        Class<?> theClass = obj.getClass();
        System.out.println("**Simple name: " + theClass.getSimpleName());
        Class<?> superClass = theClass.getSuperclass();
        System.out.println("Super simple name: " + superClass.getSimpleName());
        Class<?>[] interfaces = theClass.getInterfaces();

        for(Class<?> interfaceClass : interfaces) {
            System.out.println("Interface: " +interfaceClass.getSimpleName());
        }
    }

    public static void typeModifiers(Object obj) {
        Class<?> theClass = obj.getClass();
        int modifiers = theClass.getModifiers();
        System.out.println("CLASS: " + theClass.getSimpleName());
        if(Modifier.isAbstract(modifiers)) {
            System.out.println("ABSTRACT");
        }
        if(Modifier.isFinal(modifiers)) {
            System.out.println("FINAL");
        }
        if(Modifier.isInterface(modifiers)) {
            System.out.println("INTERFACE");
        }
        if(Modifier.isNative(modifiers)) {
            System.out.println("NATIVE");
        }
        if(Modifier.isPrivate(modifiers)) {
            System.out.println("PRIVATE");
        }
        if(Modifier.isProtected(modifiers)) {
            System.out.println("PROTECTED");
        }
        if(Modifier.isPublic(modifiers)) {
            System.out.println("PUBLIC");
        }
        if(Modifier.isStatic(modifiers)) {
            System.out.println("STATIC");
        }
        if(Modifier.isVolatile(modifiers)) {
            System.out.println("VOLATILE");
        }
    }

    public static void fieldInfo(Object obj) {
        Class<?> theClass = obj.getClass();
        Field[] fields = theClass.getFields();
        displayFields(fields);
        Field[] declaredFields = theClass.getDeclaredFields();
        displayFields(declaredFields);
    }

    public static void displayFields(Field[] arr) {
        for(Field f:arr)
            System.out.println(f.getName() + " : " + f.getType());
    }

    public static void methodInfo(Object obj) {
        Class<?> theClass = obj.getClass();

        Method[] methods = theClass.getMethods();

        System.out.println("ALL PUBLIC METHODS:");
        for(Method m:methods) {
            System.out.println("name: " + m.getName() + " " + m.getModifiers() + " return: " + m.getReturnType().getSimpleName());
        }

        System.out.println("ALL DECLARED METHODS IN CLASS ITSELF:");
        Method[] declaredMethods = theClass.getDeclaredMethods();
         for(Method m:declaredMethods) {
             System.out.println("name: " + m.getName() + " " + m.getModifiers() + " return: " + m.getReturnType().getSimpleName());
         }
    }

    public static void methodInfoInDetail(Object obj) {
        Class<?> theClass = obj.getClass();

        Method[] methods = theClass.getMethods();

        System.out.println("PUBLIC METHODS DECLARED IN PARENTS:");
        for(Method m:methods) {
            if(m.getDeclaringClass() != obj.getClass())
                System.out.println("name: " + m.getName() + " " + m.getModifiers() + " return: " + m.getReturnType().getSimpleName());
        }

        System.out.println("PUBLIC METHODS DECLARED IN CLASS ITSELF:");
        for(Method m:methods) {
            if(m.getDeclaringClass() == obj.getClass())
                System.out.println("name: " + m.getName() + " " + m.getModifiers() + " return: " + m.getReturnType().getSimpleName());
        }

    }
}
