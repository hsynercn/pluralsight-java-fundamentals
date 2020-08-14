package com.bergaz.fundamentals.generics;

public class TypeUnsafeExample {
    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(10);

        buffer.offer("a");
        buffer.offer("bc");
        buffer.offer("d");

        buffer.offer(11);

        System.out.println("Concatenate result: " + concatenate(buffer));
    }

    private static String concatenate(CircularBuffer buffer) {
        StringBuilder result = new StringBuilder();
        String value;
        /**
         * Conversion works fine for String type
         */
        while ((value = (String) buffer.poll()) != null) {
            result.append(value);
        }
        return result.toString();
    }
}
