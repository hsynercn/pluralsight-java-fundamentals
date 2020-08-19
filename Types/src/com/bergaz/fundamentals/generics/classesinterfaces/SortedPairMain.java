package com.bergaz.fundamentals.generics.classesinterfaces;

public class SortedPairMain {
    public static void main(String[] args) {
        SortedPair<Integer> pair = new SortedPair<>(1, 2);
        System.out.println("Values: first: " + pair.getFirst() + " second: " + pair.getSecond());
        SortedPair<Integer> pair1 = new SortedPair<>(12, 24);
        System.out.println("Values: first: " + pair1.getFirst() + " second: " + pair1.getSecond());
        SortedPair<Integer> pair2 = new SortedPair<>(155, -2);
        System.out.println("Values: first: " + pair2.getFirst() + " second: " + pair2.getSecond());
        SortedPair<Integer> pair3 = new SortedPair<>(-1, 22);
        System.out.println("Values: first: " + pair3.getFirst() + " second: " + pair3.getSecond());
    }
}
