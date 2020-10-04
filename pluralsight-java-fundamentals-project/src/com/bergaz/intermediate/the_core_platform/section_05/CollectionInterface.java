package com.bergaz.intermediate.the_core_platform.section_05;

import java.util.ArrayList;

public class CollectionInterface {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Foo");
        list1.add("Bar");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Baz");
        list2.add("Boo");

        list1.addAll(list2);

        for (String string : list1) {
            System.out.println(string);
        }
    }
}
