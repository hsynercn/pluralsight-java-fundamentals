package com.bergaz.fundamentals.calcengine;

public class Multiplier extends CalculateBase {

    public Multiplier() {
    }

    public Multiplier(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    @Override
    public void calculate() {
        double value = super.getLeftVal() * super.getRightVal();
        super.setResult(value);
    }
}
