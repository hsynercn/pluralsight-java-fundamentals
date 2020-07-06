package com.bergaz.calcengine;

public class Multiplier extends CalculateBase {
    @Override
    public void calculate() {
        double value = super.getLeftVal() * super.getRightVal();
        super.setResult(value);
    }
}
