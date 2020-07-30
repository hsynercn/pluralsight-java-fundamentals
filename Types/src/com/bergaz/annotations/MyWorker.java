package com.bergaz.annotations;

public class MyWorker {
    @SuppressWarnings("deprecation")
    public void doSomeWork() {
        Doer d = new Doer();
        d.doItThisWay();
    }
    @SuppressWarnings("deprecation")
    public void doDoubleWork() {
        Doer d1 = new Doer();
        Doer d2 = new Doer();
        d1.doItThisWay();
        d2.doItThisWay();
    }
}
