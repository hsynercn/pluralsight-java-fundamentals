package com.bergaz.fundamentals.generics.reflection;

import java.util.ArrayList;
import java.util.List;

public class NonReifiableExamples {
    public static void main(String[] args) {
        new NonReifiableExamples().main();
    }
    private void main() {
        List<String> strings = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();

        /**
         * Both of them are ArrayList class, they are same class
         */
        System.out.println(strings.getClass());
        System.out.println(integers.getClass());
        System.out.println(integers.getClass() == strings.getClass());

        /**
         * We can't get generic information from a string list
         */
        List<? extends Number> numbers = new ArrayList<>();
        System.out.println(numbers.getClass());
        System.out.println(numbers.getClass() == integers.getClass());

    }
}
