package com.bergaz.fundamentals.iteration_one.generics.classesinterfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingExample {
    public static void main(String[] args) {
        Person donDraper = new Person("Don Draper", 89);
        Person peggyDraper = new Person("Peggy Olson", 65);
        Person bertCooper = new Person("Bert Cooper", 100);

        List<Person> madMen = new ArrayList<>();

        madMen.add(donDraper);
        madMen.add(peggyDraper);
        madMen.add(bertCooper);

        System.out.println("Original: " + madMen);
        Collections.sort(madMen, new AgeComparator());
        System.out.println("Sorted: " + madMen);
        Collections.sort(madMen, new ReverseComparator<Person>(new AgeComparator()));
        System.out.println("Reversed: " + madMen);

        List<String> testList = new ArrayList<>();
        testList.add("bbb");
        testList.add("aaa");
        testList.add("ccc");
        Collections.sort(testList, String::compareTo);

        System.out.println("String ordering: " + testList);

    }
}
