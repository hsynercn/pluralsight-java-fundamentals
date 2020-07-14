package com.bergaz.calcengine;

public interface MathProcessing {
    String SEPERATOR = " ";
    String getKeyword();
    double doCalculation(double leftValue, double rightValue);
    default String getFormattedOutput() {
        return null;
    }
}
