package com.bergaz.intermediate.the_core_platform.section_05;

import java.util.ArrayList;

public class StronglyTypedCollectionSample {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("Foo");
        list.add("Bar");
        list.add("Fuck");

        System.out.println(list.size());

        for (String string : list) {
            System.out.println(string);
        }
    }
}
