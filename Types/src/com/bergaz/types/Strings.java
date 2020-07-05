package com.bergaz.types;

public class Strings {
    public static void main(String[] args) {
        String string1 = "World!";
        String greeting = "Hello " + string1;
        System.out.println(greeting);
        greeting += "!!!";

        //strings are immutable
        String message = "I";//hold a reference to the instance of string
        message += " LOVE";//changes in the value create a new instance of the string
        message += " JAVA";

        String a = "I love Java";
        String b = "I love Java";
        String c = "I " + "love " + "Java";
        String d = new String("I " + "love " + "Java");
        boolean bool1 = a == b;//true
        boolean bool2 = a.equals(b);//true
        boolean bool3 = a == c;//true
        boolean bool4 = a == d;//false
        String a1 = a.intern();
        String b1 = b.intern();
        boolean internCompare = a1 == b1;//true

        int iVal = 100;
        String iValStr = String.valueOf(iVal);
        String message1 = "iVal: " + iValStr;

        int david = 17, dawson = 15, dillon = 8, gordon = 6;
        String s1 = "My nephews are " + david + ", " + dawson + ", " +
                dillon + ", and " + gordon + " years old";
        String s2 = String.format(
                "My nephews are %d, %d, %d and %d years old",
                david, dawson, dillon, gordon);

        double avgDiff = ((david - dawson) + (dawson - dillon) + (dillon - gordon)) / 3.0d;
        String res3 = "Average age: " + avgDiff;
        String res4 = String.format("Average age: %.1f", avgDiff);
        //      %[argument index][flags][width][precision] conversion

        String s3 = String.format("%d", 32);
        String s4 = String.format("%x", 32);
        String s6 = String.format("%#x", 32);

        String s7 = String.format("X:%d Y:%d Z:%d T:%d",12, 6, 345, 9022);
        String s8 = String.format("X:%4d Y:%4d Z:%4d T:%4d",12, 6, 345, 9022);

        String s9 = String.format("X:%04d Y:%04d Z:%04d T:%04d",12, 6, 345, 9022);
        String s10 = String.format("X:%-4d Y:%-4d Z:%-4d T:%-4d",12, 6, 345, 9022);

        String s11 = String.format("X:%,d", 56438324);
        String s12 = String.format("X:%,.3f", 5.6438324d);

        String s13 = String.format("% d",55);
        String s14 = String.format("% d",-677);

        String s15 = String.format("% d",55);
        String s16 = String.format("% d",-677);

        String s17 = String.format("%+d",55);
        String s18 = String.format("%+d",-677);

        String s19 = String.format("%3$d %2$d %1$d", 100, 200, 300);
    }
}
