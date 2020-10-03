package com.bergaz.fundamentals.iteration_one.generics.advancedtopics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SafeVarargsExample {
    public static void main(String[] args) {
        /*Integer[] integers = arrayOf(1, 2);
        System.out.println(Arrays.toString(integers));
        System.out.println(integers.getClass());*/

        Object[] strs = pair("t");
        System.out.println(Arrays.toString(strs));
        System.out.println(strs.getClass());

        Integer[] pair = pair(1);
        System.out.println(Arrays.toString(pair));
        System.out.println(pair.getClass());
    }

    /**
     *
     * @param t
     * @param <T>
     * @return
     */
    private static <T> T[] pair(T t) {
        /**
         * We dont know the returned type of arrayOf, this is a unsafe usage
         */
        return arrayOf(t, t);
    }

    //THIS IS NOT SAFE CODE
    private static <T> T[] arrayOf(T ... values) {
        return values;
    }

    @SafeVarargs
    private static <T> List<T> combine(List<? extends T> ... lists) {
        List<T> combined = new ArrayList<>();
        for (List<? extends T> list : lists) {
            combined.addAll(list);
        }
        return combined;
    }
}
