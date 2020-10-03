package com.bergaz.fundamentals.iteration_one.generics.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExamples {
    public static void main(String[] args) {
        Person donDraper = new Person("Don Draper", 89);
        Person peggyDraper = new Person("Peggy Olson", 65);

        /**
         * List itself is an interface
         */
        List<Person> madMen = new ArrayList<Person>();

        madMen.add(donDraper);
        madMen.add(peggyDraper);

        System.out.println(madMen);

        Person bertCooper = new Person("Bert Cooper", 100);

        /**
         * We can't add any other type
         */
        madMen.add(bertCooper);
        System.out.println(madMen.get(2));
        System.out.println(madMen.size());

        for (int i = 0; i < madMen.size(); i++) {
            System.out.println(madMen.get(i));
        }

        for (Person tempPerson : madMen) {
            System.out.println(tempPerson.toString());
        }

        Iterator<Person> iterator = madMen.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            System.out.println(person);
        }


    }
}
