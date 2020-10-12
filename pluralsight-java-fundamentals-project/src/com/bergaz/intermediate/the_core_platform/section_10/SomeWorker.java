package com.bergaz.intermediate.the_core_platform.section_10;

public class SomeWorker {
    @SuppressWarnings("deprecation")
    public void doSomeWork() {
        Doer doer = new Doer();
        doer.doIt();
    }
    @SuppressWarnings("deprecation")
    public void doDoubleWork() {
        Doer doer = new Doer();
        doer.doIt();
        Doer doer1 = new Doer();
        doer1.doIt();
    }
}
