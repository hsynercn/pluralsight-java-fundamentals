package com.bergaz.intermediate.the_core_platform.section_05;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

public class CollectionsOfObjectsSample {
    public static void main(String[] args) {

        /**
         * Usually we dont use a collection without a specific type
         */

        ArrayList list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add(2223);
        list.add(new MadeUpClass());
        list.add(list);
        list.add(Paths.get("/hello_no.txt"));

        for (Object o:list) {
            System.out.println(o.toString());
        }
    }
}
