package com.bergaz.intermediate.the_core_platform.section_04;

import java.util.StringJoiner;

public class StringJoinerSample {
    public static void main(String[] args) {
        StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");
        stringJoiner.add("alpha");
        stringJoiner.add("theta");
        stringJoiner.add("gamma");

        stringJoiner.add("beta").add("zeta");

        String result = stringJoiner.toString();
        System.out.println(result);

        StringJoiner stringJoinerSquare = new StringJoiner("], [", "[", "]");
        stringJoinerSquare.add("alpha");
        stringJoinerSquare.add("theta");
        stringJoinerSquare.add("gamma");

        System.out.println(stringJoinerSquare.toString());
    }
}
