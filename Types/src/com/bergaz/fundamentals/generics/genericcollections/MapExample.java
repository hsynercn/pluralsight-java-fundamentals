package com.bergaz.fundamentals.generics.genericcollections;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Person donDraper = new Person("Don Draper", 89);
        Person peggyDraper = new Person("Peggy Olson", 65);
        Person bertCooper = new Person("Bert Cooper", 100);

        Map<String, Person> madMen = new HashMap<>();
        madMen.put(donDraper.getName(), donDraper);
        madMen.put(peggyDraper.getName(), peggyDraper);
        madMen.put(bertCooper.getName(), bertCooper);

        System.out.println(madMen.get("Don Draper"));

        for (String key : madMen.keySet()) {
            System.out.println(key);
        }

        for (Person person : madMen.values()) {
            System.out.println(person);
        }

        for (Map.Entry<String, Person> entry : madMen.entrySet()) {
            System.out.println(entry);
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }
}
