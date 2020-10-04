package com.bergaz.intermediate.the_core_platform.section_05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class RetrieveArrayFromCollectionCollectionFromArray {
    public static void main(String[] args) {
        ArrayList<MyClass> list = new ArrayList<>();

        list.add(new MyClass("v1", "abc"));
        list.add(new MyClass("v2", "xyz"));
        list.add(new MyClass("v1", "abc"));

        Object[] objArray = list.toArray();

        /**
         * Retrieve array from collection
         */
        MyClass[] a1 = list.toArray(new MyClass[0]);
        MyClass[] a2 = new MyClass[3];
        MyClass[] a3 = list.toArray(a2);

        if (a2 == a3) {
            System.out.println("a2 and a3 reference the same array");
        }

        Arrays.stream(a1).forEach(myClass -> System.out.println("a1: " + myClass));
        Arrays.stream(a3).forEach(myClass -> System.out.println("a3: " + myClass));

        /**
         * Retrieve collection from array
         */

        MyClass[] myArray = {
                new MyClass("v1", "abc"),
                new MyClass("v2", "xyz"),
                new MyClass("v1", "abc")
        };

        Collection<MyClass> myClassCollection = Arrays.asList(myArray);
        List<MyClass> myClassList = Arrays.asList(myArray);

        System.out.println("My class collection print:");
        myClassCollection.forEach(myClass -> System.out.println(myClass));

        System.out.println("My class list print");
        myClassList.forEach(myClass -> System.out.println(myClass));

    }
}
