package com.bergaz.intermediate.the_core_platform.section_05;

import java.util.TreeSet;

public class ComparableInterfaceSample {
    public static void main(String[] args) {
        MyClass myClassA = new MyClass("1", "a");
        MyClass myClassB = new MyClass("2", "b");
        MyClass myClassC = new MyClass("3", "c");

        int compareResult = myClassA.compareTo(myClassB);
        System.out.println(String.format("%s vs %s result: %+d",
                myClassA.getValue(), myClassB.getValue(), compareResult));

        System.out.println(String.format("%s vs %s result: %+d",
                myClassB.getValue(), myClassC.getValue(), compareResult));

        TreeSet<MyClass> tree = new TreeSet<>();

        tree.add(myClassA);
        tree.add(myClassB);
        tree.add(myClassC);

        tree.forEach(myClass -> System.out.println(myClass.toString()));

        System.out.println(String.format("%c %h %c %d %c %d", 'a', (int) 'a', 'b', (int) 'b', 'c', (int) 'c'));
    }
}
