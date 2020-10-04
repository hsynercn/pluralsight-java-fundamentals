package com.bergaz.intermediate.the_core_platform.section_04;

public class CommonFormatConversions {
    public static void main(String[] args) {
        System.out.println(String.format("Decimal:%d", 32));
        System.out.println(String.format("Decimal:%d", (short)'s'));

        System.out.println(String.format("Octal:%o", 32));
        System.out.println(String.format("Octal:%o", 2232));

        System.out.println(String.format("%x", 32));
        System.out.println(String.format("%X", 32));

        System.out.println(String.format("%f", 123.123456f));
        System.out.println(String.format("%.20f", 123.123456789123f));

        System.out.println(String.format("%e", 123.123d));

        System.out.println(String.format("%E", 123.123f));

        System.out.println(String.format("%s", new FormattableClassSample()));
        System.out.println(String.format("%s", new ToStringClassSample()));

    }
}
