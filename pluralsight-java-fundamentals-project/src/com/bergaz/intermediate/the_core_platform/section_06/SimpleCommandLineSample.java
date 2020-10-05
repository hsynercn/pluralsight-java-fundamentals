package com.bergaz.intermediate.the_core_platform.section_06;

public class SimpleCommandLineSample {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("No arguments");
        } else {
            for (String argument : args) {
                System.out.println(argument);
            }
        }
    }
}
