package com.bergaz.intermediate.the_core_platform.section_05;

import java.util.ArrayList;

public class ForEachSample {
    public static void main(String[] args) {
        ArrayList<MyClass> list = new ArrayList<>();

        list.add(new MyClass("v1", "abc"));
        list.add(new MyClass("v2", "xyz"));
        list.add(new MyClass("v3", "abc"));
        list.add(new MyClass("v4", "xyz"));

        System.out.println("For each:");
        list.forEach(myClass -> System.out.println(myClass.getLabel()));

        System.out.println("Remove and for each");
        list.removeIf(myClass -> myClass.getValue().equalsIgnoreCase("abc"));
        list.forEach(myClass -> System.out.println(myClass.getLabel()));

        System.out.println("For each after classic remove, only removes first match");
        list.remove(new MyClass("v4", "xyz"));
        list.forEach(myClass -> System.out.println(myClass.getLabel()));
    }
}
