package com.bergaz.intermediate.the_core_platform.section_04;

public class FormattingVsConcatenation {
    public static void main(String[] args) {
        int david = 13, dawson = 11, dillon = 4, gordon = 2;
        String string1 = "My nephews are " + david + ", " + dawson + ", " + dillon + ", and " + gordon + " years old.";
        System.out.println(string1);

        String string2 = String.format("My nephews are %d, %d, %d, and %d years old.", david, dawson, dillon, gordon);
        System.out.println(string2);

        double avgVal = ((david - dawson) + (dawson - dillon) + (dillon - gordon)) / 3.0d;
        String string3 = "The average age between each is " + avgVal + " years.";
        System.out.println(string3);

        String string4 = String.format("The average age between each is %.1f years.", avgVal);
        String string41 = String.format("The average age between each is %.3f years.", avgVal);
        String string42 = String.format("The average age between each is %.5f years.", avgVal);
        System.out.println(string4);
        System.out.println(string41);
        System.out.println(string42);

        float testFloat = 13.44888767656347f / 4.0f;
        System.out.println("Test float out: " + testFloat);
        System.out.println(String.format("Test float out: %.9f", testFloat));
    }
}
