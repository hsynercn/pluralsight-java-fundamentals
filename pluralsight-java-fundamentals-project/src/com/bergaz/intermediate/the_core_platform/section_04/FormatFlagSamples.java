package com.bergaz.intermediate.the_core_platform.section_04;

import java.util.stream.Stream;

public class FormatFlagSamples {
    public static void main(String[] args) {
        String s1 = String.format(">%d<", 32);
        String s2 = String.format(">%o<", 32);
        String s3 = String.format(">%x<", 32);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        String s4 = String.format(">%d<", 32);
        String s5 = String.format(">%#o<", 32);
        String s6 = String.format(">%#x<", 32);
        String s7 = String.format(">%#X<", 32);
        String s8 = String.format(">%#f<", 32.32f);
        String s9 = String.format(">%e<", 123.123f);
        String s10 = String.format(">%E<", 123.123f);

        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);
        System.out.println(s7);
        System.out.println(s8);
        System.out.println(s9);
        System.out.println(s10);

        String s11 = String.format(">%d, %d<",223, 25);
        String s12 = String.format(">%d, %d<",1, 235);
        System.out.println(s11);
        System.out.println(s12);

        String s13 = String.format(">%4d %4d<", 223, 25);
        String s14 = String.format(">%4d %4d<", 1, 235);
        System.out.println(s13);
        System.out.println(s14);

        String s15 = String.format(">%04d %04d<", 223, 25);
        String s16 = String.format(">%04d %04d<", 1, 235);
        System.out.println(s15);
        System.out.println(s16);

        String s17 = String.format(">%-4d %-4d<", 223, 25);
        String s18 = String.format(">%-4d %-4d<", 1, 235);
        System.out.println(s17);
        System.out.println(s18);

        String s19 = String.format(">%.10e<", 12345.12356);
        System.out.println(s19);

        String s20 = String.format(">%,.10f<", 1234.1234f);
        String s21 = String.format(">%,d<", 1234567);
        String s22 = String.format(">%,d<", -1234567);
        System.out.println(s20);
        System.out.println(s21);
        System.out.println(s22);

        String s23 = String.format(">%d<", 12345);
        String s24 = String.format(">%d<", -45678);
        System.out.println(s23);
        System.out.println(s24);

        String s25 = String.format(">% d<", 12345);
        String s26 = String.format(">% d<", -45678);
        System.out.println(s25);
        System.out.println(s26);

        String s27 = String.format(">% 010d<", 12345);
        String s28 = String.format(">% 010d<", -45678);
        System.out.println(s27);
        System.out.println(s28);

        String s29 = String.format(">%, 010d<", 12345);
        String s30 = String.format(">%, 010d<", -45678);
        System.out.println(s29);
        System.out.println(s30);

        String s31 = String.format(">%,+010d<", 12345);
        String s32 = String.format(">%,+010d<", -45678);
        System.out.println(s31);
        System.out.println(s32);

        String s33 = String.format(">%,(010d<", 12345);
        String s34 = String.format(">%,(010d<", -45678);
        System.out.println(s33);
        System.out.println(s34);
    }
}
