package com.bergaz.fundamentals.iteration_one.generics.conceptintro;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add(1);

        /**
         * We get class java.lang.Integer cannot be cast to class java.lang.String exception
         */
        //String result = (String) list.get(2);
        //System.out.println(result);

        /**
         * One benefit of generics:
         * Generics stop runtime errors at compile time
         * We can set String type for upper list array, by this way we get a compile error for adding an integer to
         * this array
         */



    }
}
