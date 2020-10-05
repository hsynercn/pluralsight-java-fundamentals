package com.bergaz.intermediate.the_core_platform.section_06;

public class SystemProperties {
    public static void main(String[] args) {
        System.getProperties().forEach((o, o2) -> System.out.println(o + " | " + o2));
    }
}
