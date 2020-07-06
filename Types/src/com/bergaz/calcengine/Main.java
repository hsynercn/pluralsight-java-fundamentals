package com.bergaz.calcengine;

public class Main {
    public static void main(String[] args) {
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
    }
}
