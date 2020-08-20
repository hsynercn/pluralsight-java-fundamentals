package com.bergaz.fundamentals.generics.rawtypes;

import java.beans.Customizer;
import java.util.List;

public class ReifiedTypesMain {
    public static void main(String[] args) {
        String[] strings = new String[3];
        Object[] objects = strings;
        //objects[0] = 1;

        List arrayList = new ObjectCustomArrayList();

        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);

        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.get(2));

        List<Integer> integerList = new GenericCustomArrayList<>();
        integerList.add(0);
        integerList.add(1);
        integerList.add(2);

        /**
         * We get a compile time error for below line
         */
        //integerList.add("test");

        System.out.println("integerList[0] = " + integerList.get(0));
        System.out.println("integerList[1] = " + integerList.get(1));
        System.out.println("integerList[2] = " + integerList.get(2));
    }
}
