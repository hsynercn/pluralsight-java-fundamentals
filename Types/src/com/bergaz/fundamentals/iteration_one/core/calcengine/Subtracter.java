package com.bergaz.fundamentals.iteration_one.core.calcengine;

public class Subtracter extends CalculateBase {

    public Subtracter() {
    }

    public Subtracter(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    @Override
    public void calculate() {
        double value = super.getLeftVal() - super.getRightVal();
        super.setResult(value);
    }
}