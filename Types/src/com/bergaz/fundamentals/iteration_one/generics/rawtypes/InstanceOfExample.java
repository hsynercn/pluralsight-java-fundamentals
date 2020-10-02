package com.bergaz.fundamentals.iteration_one.generics.rawtypes;

public class InstanceOfExample<T> {
    @Override
    public boolean equals(Object obj) {

        /**
         * SECOND ERASURE PROBLEM
         * We can't use keyword instanceof for generic type parameter
         * Illegal generic type for instanceof
         * In run time this class does not really exist
         */
        //if (obj instanceof InstanceOfExample<T>) {
        if (obj instanceof InstanceOfExample) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new InstanceOfExample() instanceof InstanceOfExample);//we get true
        System.out.println(new InstanceOfExample() instanceof Object);//we get true
    }
}
