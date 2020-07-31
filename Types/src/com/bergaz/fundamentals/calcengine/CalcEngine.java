package com.bergaz.fundamentals.calcengine;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

public class CalcEngine {
    public static void main(String[] args) {
        double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
        double[] rightVals = { 50.0d, 92.0d, 17.0d, 3.0d};
        char[] opCodes = {'d', 'a', 's', 'm'};
        double[] results = new double[opCodes.length];

        if( args.length == 0 ) {
            for(int i = 0; i < opCodes.length; i++) {
                results[i] = execute(opCodes[i], leftVals[i], rightVals[i]);
            }
            for(double temp : results) {
                System.out.println(temp);
            }
        } else if(args.length == 1 && args[0].equals("interactive")) {
            executeInteractively();
        } else if(args.length == 3){
            handleCommandLine(args);
        } else {
            System.out.println("Invalid input");
        }
    }

    static void executeInteractively() {
        System.out.println("Enter an operation and two numbers:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        performOperation(parts);
    }

    private static void performOperation(String[] parts) {
        char opCode = opCodeFromString(parts[0]);
        if(opCode == 'w') {
            handleWhen(parts);
        } else {
            double leftVal = valueFromWord(parts[1]);
            double rightVal = valueFromWord(parts[2]);
            double result = execute(opCode, leftVal, rightVal);
            displayResult(opCode, leftVal, rightVal, result);
        }
    }

    private static void handleWhen(String[] parts) {
        LocalDate startDate = LocalDate.parse(parts[1]);
        long daysToAdd = (long) valueFromWord(parts[2]);
        LocalDate newDate = startDate.plusDays(daysToAdd);
        String out = String.format("%s plus %d is %d", startDate, daysToAdd, newDate);
    }

    private static char symbolFromOpCode(char opCode) {
        HashMap<Character, Character> opMap = new HashMap<>();
        opMap.put('a', '+');
        opMap.put('s', '-');
        opMap.put('m', '*');
        opMap.put('d', '/');
        return opMap.get(opCode);
    }

    private static void displayResult(char opCode, double leftVal, double rightVal, double result) {
        char symbol = symbolFromOpCode(opCode);
        //StringBuilder builder = new StringBuilder(20);
        //builder.append(leftVal).append(" ").append(symbol);
        //builder.append(" ").append(rightVal).append( " = ");
        //builder.append(result);
        //System.out.println(builder.toString());
        String output = String.format("%.2f %c %.2f = %.2f",leftVal, opCode, rightVal, result);
    }

    private static void handleCommandLine(String[] args) {
        char opCode = args[0].charAt(0);
        double leftVal = Double.parseDouble(args[1]);
        double rightVal = Double.parseDouble(args[2]);
        double res = execute(opCode, leftVal, rightVal);
        System.out.println(res);
    }

    static double execute(char opCode, double leftVal, double rightVal) {
        double result;
        switch (opCode) {
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'd':
                result = rightVal != 0 ? leftVal / rightVal : 0.0d;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            default:
                System.out.println("Invalid op code");
                result = 0.0d;
        }
        return result;
    }

    static char opCodeFromString(String operationName) {
        char opCode = operationName.charAt(0);
        return opCode;
    }

    static double valueFromWord(String word) {
        String[] numberWords = {
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"
        };
        double value = 0d;
        for(String temp : numberWords) {
            if(temp.equals(word)) {
                return value;
            } else {
                value += 1.0d;
            }
        }
        return value;
    }
}
