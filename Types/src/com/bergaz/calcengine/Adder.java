package com.bergaz.calcengine;

public class Adder extends CalculateBase {

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
}
