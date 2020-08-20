package com.bergaz.fundamentals.generics.rawtypes;

import java.util.List;

/**
 * Overloading problem of erasure
 */
public class Overloading {
    public void print(Integer param) {

    }

    public void print(String param) {

    }

    public void print(List<String> param) {

    }

    /**
     * 1-FIRST ERASURE PROBLEM
     * We can't overload a list parameter
     * @param param
     */
    /*
    public void print(List<Integer> param) {

    }*/
}
