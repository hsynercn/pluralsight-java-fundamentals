package com.bergaz.fundamentals.iteration_one.generics.conceptintro;

import com.bergaz.fundamentals.iteration_one.generics.conceptintro.circularbuffer.StringCircularBuffer;

public class TypeSafeExample {
    public static void main(String[] args) {
        StringCircularBuffer buffer = new StringCircularBuffer(10);

        buffer.offer("a");
        buffer.offer("bc");
        buffer.offer("d");

        /**
         * We have converted the runtime error to compile time error
         */
        //buffer.offer(1);

        System.out.println("Concatenate result: " + concatenate(buffer));
    }

    private static String concatenate(StringCircularBuffer buffer) {
        StringBuilder result = new StringBuilder();
        String value;
        /**
         * Conversion works fine for String type
         */
        while ((value = buffer.poll()) != null) {
            result.append(value);
        }
        return result.toString();
    }
}
