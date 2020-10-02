package com.bergaz.fundamentals.iteration_one.generics.rawtypes;

public class MemoryAccessMain {
    public static void main(String[] args) {
        /**
         * Flat array, easy to predict next memory access
         * Sequentially local
         * Friendly to CPU cache
         */
        int[] intArray = new int[10];

        /**
         * Randomly distributed Integer objects on memory
         * In worst case 8x fatter
         */
        Integer[] integerArray = new Integer[10];
    }
}
