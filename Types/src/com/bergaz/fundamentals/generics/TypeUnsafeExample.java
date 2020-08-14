package com.bergaz.fundamentals.generics;

import com.bergaz.fundamentals.generics.circularbuffer.ObjectCircularBuffer;

public class TypeUnsafeExample {
    public static void main(String[] args) {
        ObjectCircularBuffer buffer = new ObjectCircularBuffer(10);

        buffer.offer("a");
        buffer.offer("bc");
        buffer.offer("d");

        buffer.offer(11);

        System.out.println("Concatenate result: " + concatenate(buffer));
    }

    private static String concatenate(ObjectCircularBuffer buffer) {
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
