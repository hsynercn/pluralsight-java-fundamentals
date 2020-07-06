package com.bergaz.calcengine;

public class Divider extends CalculateBase {
    @Override
    public void calculate() {
        double value = getRightVal() != 0 ? getLeftVal() / getRightVal() : 0.0d;
        super.setResult(value);
    }
}
