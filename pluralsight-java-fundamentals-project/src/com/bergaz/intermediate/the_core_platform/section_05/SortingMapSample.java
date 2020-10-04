package com.bergaz.intermediate.the_core_platform.section_05;

import java.util.SortedMap;
import java.util.TreeMap;

public class SortingMapSample {
    public static void main(String[] args) {
        SortedMap<String, String> sortedMap = new TreeMap<>();

        sortedMap.put("3333", "ghi");
        sortedMap.put("2222", "abc");
        sortedMap.put("1111", "def");
        sortedMap.put("6666", "xyz");
        sortedMap.put("4444", "mno");
        sortedMap.put("5555", "pqr");

        /**
         * Pay attention to key order for head, tail seperation
         */

        sortedMap.forEach((key, value) -> System.out.println(key + " | " + value));

        String cutKey = "4444";

        SortedMap<String, String> sortedMapHead = sortedMap.headMap(cutKey);
        SortedMap<String, String> sortedMapTail = sortedMap.tailMap(cutKey);

        System.out.println("HEAD MAP of " + cutKey);
        sortedMapHead.forEach((key, value) -> System.out.println(key + " | " + value));

        System.out.println("TAIL MAP of " + cutKey);
        sortedMapTail.forEach((key, value) -> System.out.println(key + " | " + value));

    }
}
