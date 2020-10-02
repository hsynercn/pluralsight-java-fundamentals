package com.bergaz.fundamentals.iteration_one.core.calcengine;

public interface MathProcessing {
    String SEPERATOR = " ";
    String getKeyword();
    double doCalculation(double leftValue, double rightValue);
    default String getFormattedOutput() {
        return null;
    }
}
