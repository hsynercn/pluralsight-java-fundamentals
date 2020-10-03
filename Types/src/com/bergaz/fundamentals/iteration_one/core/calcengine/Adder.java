package com.bergaz.fundamentals.iteration_one.core.calcengine;

public class Adder extends CalculateBase implements MathProcessing{

    public Adder() {
    }

    public Adder(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    @Override
    public void calculate() {
        double value = super.getLeftVal() + super.getRightVal();
        super.setResult(value);
    }

    @Override
    public String getKeyword() {
        return "+";
    }

    @Override
    public double doCalculation(double leftValue, double rightValue) {
        setLeftVal(leftValue);
        setRightVal(rightValue);
        calculate();
        return getResult();

    }
}
