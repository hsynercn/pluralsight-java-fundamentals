package com.bergaz.fundamentals.iteration_one.generics.classesinterfaces;

import java.util.Comparator;

public class ReverseComparator<T> implements Comparator<T> {
    private Comparator<T> delegateComparator;

    public ReverseComparator(Comparator<T> delegateComparator) {
        this.delegateComparator = delegateComparator;
    }

    @Override
    public int compare(T left, T rigt) {
        return -1 * delegateComparator.compare(left, rigt);
    }
}
