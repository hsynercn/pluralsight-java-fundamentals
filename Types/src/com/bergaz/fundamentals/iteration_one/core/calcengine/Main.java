package com.bergaz.fundamentals.iteration_one.core.calcengine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //oldCalculations();
        doCalculation(new Divider(), 100.0d, 50.0d);
        doCalculation(new Adder(), 100.0d, 50.0d);
    }

    static void executeInteractively() {
        System.out.println("Enter an operation and two numbers:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        performOperation(parts);
    }
    private static void performOperation(String[] parts) {
        MathOperation operation = MathOperation.valueOf(parts[0].toUpperCase());
        double leftVal = Double.parseDouble(parts[1]);
        double rightVal = Double.parseDouble(parts[2]);
        CalculateBase calculateBase = createCalculateBase(operation, leftVal, rightVal);
        calculateBase.calculate();
    }

    private static CalculateBase createCalculateBase(MathOperation operation, double leftValue, double rightValue) {
        CalculateBase calculation = null;
        switch (operation) {
            case ADD -> calculation = new Adder(leftValue,rightValue);
            case DIVIDE -> calculation = new Divider(leftValue, rightValue);
            case MULTIPLY -> calculation = new Multiplier(leftValue, rightValue);
            case SUBTRACT -> calculation = new Subtracter(leftValue, rightValue);
        }
        return calculation;
    }

    static void doCalculation(CalculateBase calculateBase, double leftValue, double rightValue) {
        calculateBase.setLeftVal(leftValue);
        calculateBase.setRightVal(rightValue);
        calculateBase.calculate();
        System.out.println("RESULT: " + calculateBase.getResult());
    }

    static void oldCalculations() {
        MathEquation[] mathEquations = new MathEquation[4];
        mathEquations[0] = new MathEquation(100.0d, 50.0d, 'd');
        mathEquations[1] = new MathEquation(25.0d, 92.0d, 'a');
        mathEquations[2] = new MathEquation(225.0d, 17.0d, 's');
        mathEquations[3] = new MathEquation(11.0d, 3.0d, 'm');
        for(MathEquation mathEquation : mathEquations) {
            mathEquation.execute();
            System.out.println("result: " + mathEquation.getResult());
        }
        System.out.println("Average result: " + MathEquation.getAverageResult());

        MathEquation equation = new MathEquation('d');
        equation.execute(9.0d, 3.5d);

        MathEquation equation2 = new MathEquation('d');
        equation2.execute(9, 3);
    }
}
