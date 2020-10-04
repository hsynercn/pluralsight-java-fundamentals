package com.bergaz.intermediate.the_core_platform.section_04;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringRegexSample {
    public static void main(String[] args) {
        String string1 = "apple, apple and orange please";

        String string2 = string1.replaceAll("ple", "ricot");
        System.out.println(string2);

        String string3 = string1.replaceAll("ple\\b", "ricot");
        System.out.println(string3);

        String[] parts = string1.split("\\b");
        for (String part : parts) {
            if (part.matches("\\w+")) {
                System.out.println(part);
            }
        }

        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(string1);

        System.out.println("Matcher run:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
