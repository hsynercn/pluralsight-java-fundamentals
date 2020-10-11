package com.bergaz.intermediate.the_core_platform.section_09;

import java.lang.reflect.Method;
import java.util.Arrays;

public class AccessingMethodInformation {
    public static void main(String[] args) {
        Class<?> aClass = HighVolumeAccount.class;
        Method[] methods = aClass.getMethods();
        System.out.println("Public declared and inherited methods:");
        printFilterMethods(methods);
        Method[] declaredMethods = aClass.getDeclaredMethods();
        System.out.println("\n\nPublic, private and protected declared methods:");
        printFilterMethods(declaredMethods);
    }
    public static void printMethodArray(Method[] methods) {
        Arrays.asList(methods).forEach(method -> System.out.println(method.getName() +
                " : returns " + method.getReturnType()));
    }

    public static void printFilterMethods(Method[] methods) {
        Arrays.asList(methods).forEach(method -> {
            if (method.getDeclaringClass() != Object.class) {
                System.out.println(method.getName() +" : returns " + method.getReturnType());
            }
        });
    }

}
