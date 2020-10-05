package com.bergaz.intermediate.the_core_platform.section_06;

public class EnvironmentVariables {
    public static void main(String[] args) {
        System.getenv().forEach((s, s2) -> System.out.println(s + " | " + s2));
    }
}
