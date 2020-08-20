package com.bergaz.fundamentals.generics.classesinterfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingAnonymousClassExample {
    public static void main(String[] args) {

        Person donDraper = new Person("Don Draper", 89);
        Person peggyDraper = new Person("Peggy Olson", 65);
        Person bertCooper = new Person("Bert Cooper", 100);

        List<Person> madMen = new ArrayList<>();

        madMen.add(donDraper);
        madMen.add(peggyDraper);
        madMen.add(bertCooper);

        Collections.sort(madMen, new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
                return Integer.compare(person1.getAge(), person2.getAge());
            }
        });

        System.out.println(madMen);
    }
}
