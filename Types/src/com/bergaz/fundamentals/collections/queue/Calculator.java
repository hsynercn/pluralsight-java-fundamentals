package com.bergaz.fundamentals.collections.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {
    public int evaluate(final String input) {
        Deque<String> stack = new ArrayDeque<>();
        String[] tokens = input.split(" ");
        for(String token : tokens) {
            stack.push(token);
        }

        while (stack.size() > 1) {
            int left = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int right = Integer.parseInt(stack.pop());
            int result = 0;
            switch (operator) {
                case "+":
                    result = left + right;
                    break;
                case "-":
                    result = left - right;
                    break;
            }
            stack.push(String.valueOf(result));
        }

        return Integer.parseInt(stack.pop());
    }
}
