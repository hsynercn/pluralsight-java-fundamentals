package com.bergaz.fundamentals.workwithnulls;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        /**
         * we can use var for variable initialization, Java 10 nad later compilers can understand the return type of method
         *
         */
        var whatISVar = new Book("TEST");

        /**
         * Still we can't use null initialization, var ıs a syntactic sugar
         */
        //var obj = null;

        var obj = (Object)null;

        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = o2;

        System.out.println("o1 == o2: " + (o1 == o2));
        System.out.println("o2 == o3: " + (o2 == o3));
        System.out.println("null == null: " + (null == null));

        /**
         * We can't assign null to primitive types, we can use wrapper classes
         */
        //int i = null;//this line gives a compile error
        Integer i = null;
    }

    public static void isBookReadyForPublication(Book book) {
        /**
         * Assertions are disabled in default configuration, we can enable them for development and disable them at
         * production
         */
        assert  book != null : "Book is null";
    }

    /**
     * We can use a if check for null values
     * @param book
     */
    public static void isBookReadyForPublicationIf(Book book) {
        if (book != null) {
            System.out.println("Book is not null");
        } else {
            System.out.println("Book is null");
        }
    }

    /**
     * Java 7 introduces requireNonNull, we can customize an error message
     * @param book
     */
    public static void isBookReadyForPublicationRequire(Book book) {
        Objects.requireNonNull(book, "Book is null");
    }

    /**
     * In most cases we get a exception at the end, this rule applies for upper null handling methods
     * Mostly we use exceptions for performance
     * @param book
     */
    public static void isBookReadyForPublicationException(Book book) {
        try {

        } catch (NullPointerException exception) {

        }
    }

}
