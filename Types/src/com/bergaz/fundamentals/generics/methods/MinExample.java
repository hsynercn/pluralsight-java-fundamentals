package com.bergaz.fundamentals.generics.methods;

import java.util.*;

public class MinExample {
    public static void main(String[] args) {
        Person donDraper = new Person("Don Draper", 89);
        Person peggyDraper = new Person("Peggy Olson", 65);
        Person bertCooper = new Person("Bert Cooper", 100);

        List<Person> madMen = new ArrayList<>();
        madMen.add(donDraper);
        madMen.add(peggyDraper);
        madMen.add(bertCooper);

        Person youngestCastMember = (Person) min(madMen, new AgeComparator());

        /**
         * I made a mistake while using the generic type method, I made a dependency mistake, referenced another package
         * AgeComparator thus another Person class referenced
         */
        Person youngestCastMember1 = (Person) minWithT(madMen, new AgeComparator());

        //We don't get a compile error from this code block, we get a runtime exception
        /*
        Person youngestCastMember1 = (Person) min(madMen, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        */
    }

    /**
     * For <T> for type parameter. After we declare T we can use for other things like T for return type
     * @param values
     * @param comparator
     * @param <T>
     * @return
     */
    public static <T> T minWithT(List<T> values, Comparator<T> comparator) {
        if (values.isEmpty()) {
            throw new IllegalArgumentException("List is empty, cannot find minimum");
        }
        T lowestElement = values.get(0);
        for (int i = 0; i < values.size(); i++) {
            T element = values.get(i);
            if (comparator.compare(element, lowestElement) < 0) {
                lowestElement = element;
            }
        }
        return lowestElement;
    }

    public static Object min(List values, Comparator comparator) {
        if (values.isEmpty()) {
            throw new IllegalArgumentException("List is empty, cannot find minimum");
        }
        Object lowestElement = values.get(0);
        for (int i = 0; i < values.size(); i++) {
            Object element = values.get(i);
            if (comparator.compare(element, lowestElement) < 0) {
                lowestElement = element;
            }
        }
        return lowestElement;
    }

}
