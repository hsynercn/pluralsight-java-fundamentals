package com.bergaz.fundamentals.generics.conceptintro;

import com.bergaz.fundamentals.generics.conceptintro.circularbuffer.CircularBuffer;

public class TypeUnsafeExampleWithGenerics {
    public static void main(String[] args) {
        CircularBuffer<String> buffer = new CircularBuffer(10);

        buffer.offer("a");
        buffer.offer("bc");
        buffer.offer("d");

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
