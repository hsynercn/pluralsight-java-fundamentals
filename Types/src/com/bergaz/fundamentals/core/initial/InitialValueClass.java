package com.bergaz.fundamentals.core.initial;

public class InitialValueClass {
    byte x;
    short y;
    int z;
    long t;
    float g;
    double h;
    char o;
    String s;
    boolean b;

    public InitialValueClass() {

    }

    public InitialValueClass(byte x) {
        this.x = x;
    }

    public InitialValueClass(byte x, short y) {
        this(x);
        this.y = y;
    }

    public  InitialValueClass(byte x, short y, int z) {
        this(x, y);
        this.z = z;
    }
}
