package com.bergaz.fundamentals.iteration_one.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

public class ObjectVsQuestionMarkMain {
    public static void main(String[] args) {
        /**
         * Arrays are covariant
         */

        Object[] array = new Person[1];
        array[0] = new Person("Test", 1);
        //array[0] = new Object(); //throws java.lang.ArrayStoreException

        List<Object> objectList = new ArrayList<>();
        objectList.add(new Object());
        objectList.add(new Person("Test", 1));

        /**
         * null can be coerced to any type
         */
        List<?> objects = new ArrayList<>();
        objects.add(null);
    }
}
