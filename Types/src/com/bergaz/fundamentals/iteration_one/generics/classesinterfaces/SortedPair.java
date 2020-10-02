package com.bergaz.fundamentals.iteration_one.generics.classesinterfaces;

/*
Recursive type parameter declaration
 */
public class SortedPair<T extends Comparable<T>> {
    private final T first;
    private final T second;

    public SortedPair(T left, T right) {
        if (left.compareTo(right) < 0) {
            this.first = left;
            this.second = right;
        } else {
            this.first = right;
            this.second = left;
        }
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}
