package com.bergaz.fundamentals.iteration_one.generics.classesinterfaces;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {
    /*
    We can flip the order by multiplying the compare result by -1
     */
    @Override
    public int compare(Person left, Person right) {
        return Integer.compare(left.getAge(), right.getAge());
    }
}
