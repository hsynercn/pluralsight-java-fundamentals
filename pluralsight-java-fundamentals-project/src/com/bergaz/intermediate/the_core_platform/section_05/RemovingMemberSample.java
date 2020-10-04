package com.bergaz.intermediate.the_core_platform.section_05;

import java.util.ArrayList;

public class RemovingMemberSample {
    public static void main(String[] args) {
        ArrayList<MyClass> list = new ArrayList<>();

        MyClass v1 = new MyClass("v1", "abc");
        MyClass v2 = new MyClass("v2", "abc");
        MyClass v3 = new MyClass("v3", "abc");

        list.add(v1);
        list.add(v2);
        list.add(v3);

        /**
         * Uses equals method to find match, removes first match, in this case it is v1
         */

        list.remove(v3);

        for (MyClass temp:list) {
            System.out.println(temp.getLabel());
        }
    }
}
