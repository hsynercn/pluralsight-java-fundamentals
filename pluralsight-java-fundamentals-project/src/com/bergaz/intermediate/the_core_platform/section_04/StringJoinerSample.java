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

        StringJoiner stringJoinerSingle = new StringJoiner(", ");
        stringJoinerSingle.add("alpha");
        System.out.println(stringJoinerSingle.toString());

        StringJoiner stringJoinerSingleBracers = new StringJoiner(", ", "{", "}");
        stringJoinerSingleBracers.add("alpha");
        System.out.println(stringJoinerSingleBracers.toString());

        StringJoiner stringJoinerEmpty = new StringJoiner(", ");
        System.out.println(stringJoinerEmpty.toString());

        StringJoiner stringJoinerEmptyBracers = new StringJoiner(", ", "{", "}");
        System.out.println(stringJoinerEmptyBracers.toString());

        StringJoiner stringJoinerEmptyState = new StringJoiner(", ", "{", "}");
        stringJoinerEmptyState.setEmptyValue("THIS IS EMPTY");
        System.out.println(stringJoinerEmptyState.toString());

        StringJoiner stringJoinerNotEmpty = new StringJoiner(", ");
        stringJoinerNotEmpty.add("");
        System.out.println(stringJoinerNotEmpty.toString());

        StringJoiner stringJoinerNotEmptyWithBraces = new StringJoiner(", ", "{", "}");
        stringJoinerNotEmptyWithBraces.add("");
        System.out.println(stringJoinerNotEmptyWithBraces.toString());
    }
}
