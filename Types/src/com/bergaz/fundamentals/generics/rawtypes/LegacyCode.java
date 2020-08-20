package com.bergaz.fundamentals.generics.rawtypes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LegacyCode {
    public static void main(String[] args) {
        /**
         * Pre generics raw type
         */
        List list = new ArrayList();
        //List<Object> list = new ArrayList(); //This works but not same with List
        list.add("abc");
        list.add(1);
        list.add(new Object());

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            System.out.println(element);
        }

        /**
         * We don't get a compile error, but this is a unsafe scenario
         */
        List<String> strings = list;

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);

        List param;

        legacyMethod(integers);

        /**
         * This flexibility costs us security, we can get lots of type conversion exceptions
         */
    }

    public static void legacyMethod(List list) {

    }
}
