package com.bergaz.intermediate.the_core_platform.section_05;

import java.util.HashMap;
import java.util.Map;

public class MapSample {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("2222", "ghi");
        map.put("3333", "abc");
        map.put("1111", "def");

        System.out.println(map.get("2222"));

        System.out.println(map.get("9999"));

        System.out.println(map.getOrDefault("8888", "NOT FOUND ANYTHING"));

        System.out.println("For each print");
        map.forEach(((key, value) -> System.out.println(key + " > " + value)));

        map.replaceAll(((key, value) -> value.toUpperCase()));

        System.out.println("For each print");
        map.forEach(((key, value) -> System.out.println(key + " > " + value)));


    }
}
