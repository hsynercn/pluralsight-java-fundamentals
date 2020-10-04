package com.bergaz.intermediate.the_core_platform.section_05;

import java.util.TreeSet;

public class ComparatorSample {
    public static void main(String[] args) {
        TreeSet<MyClass> treeSet = new TreeSet<>(new MyComparator());

        MyClass myClassA = new MyClass("2", "a");
        MyClass myClassB = new MyClass("3", "b");
        MyClass myClassC = new MyClass("1", "c");

        treeSet.add(myClassA);
        treeSet.add(myClassB);
        treeSet.add(myClassC);

        treeSet.forEach(myClass -> System.out.println(myClass.toString()));
    }
}
