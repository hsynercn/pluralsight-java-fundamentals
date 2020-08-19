package com.bergaz.fundamentals.generics.collections;

import java.util.HashSet;
import java.util.Set;

public class SetExamples {
    public static void main(String[] args) {
        Person donDraper = new Person("Don Draper", 89);
        Person peggyDraper = new Person("Peggy Olson", 65);
        Person bertCooper = new Person("Bert Cooper", 100);

        /*
          ArrayList does not insure uniqueness
         */

        /*
        List<Person> madMen = new ArrayList<>();
        madMen.add(donDraper);
        madMen.add(peggyDraper);
        madMen.add(donDraper);
        */

        Set<Person> madMen = new HashSet<>();
        madMen.add(donDraper);
        madMen.add(peggyDraper);
        madMen.add(donDraper);

        /*
          We see only one donDraper
         */

        for (Person tempPerson : madMen) {
            System.out.println(tempPerson);
        }

        System.out.println("donDraper:" + madMen.contains(donDraper));
        System.out.println("bertCooper: " + madMen.contains(bertCooper));
    }
}
