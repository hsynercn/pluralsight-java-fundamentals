package com.bergaz.intermediate.the_core_platform.section_04;

public class ArgumentIndexSample {
    public static void main(String[] args) {
        String string1 = String.format("%d %d %d", 100, 200, 300);
        String string2 = String.format("%3$d %2$d %1$d", 100, 200, 300);
        String string3 = String.format("%1$d %3$d %2$d", 100, 200, 300);
        String string4 = String.format("%2$d %1$d %3$d", 100, 200, 300);

        System.out.println(string1);
        System.out.println(string2);
        System.out.println(string3);
        System.out.println(string4);

        String string5 = String.format("%2$d %<,+010d %1$d", 3333, 4444);
        System.out.println(string5);
    }
}
