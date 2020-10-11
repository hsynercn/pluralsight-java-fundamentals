package com.bergaz.intermediate.the_core_platform.section_09;

import java.util.Arrays;
import java.util.Objects;

public class ClassInfo {
    public static void getInfo(Object obj) {
        Class<?> theClass = obj.getClass();
        System.out.println("Class simple name: " + theClass.getSimpleName());

        Class<?> superClass = theClass.getSuperclass();
        System.out.println("Superclass simple name: " + superClass.getSimpleName());

        Class<?>[] interfaces = theClass.getInterfaces();
        Arrays.asList(interfaces).forEach(aInterface -> System.out.println("Interfaces: " + aInterface.getSimpleName()));
    }
}
