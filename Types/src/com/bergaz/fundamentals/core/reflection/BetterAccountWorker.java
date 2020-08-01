package com.bergaz.fundamentals.core.reflection;

public class BetterAccountWorker implements Runnable, TaskWorker{
    BankAccount ba;
    @Override
    public void setTarget(Object target) {
        if(BankAccount.class.isInstance(target)) {
            ba = (BankAccount) target;
        } else {
            throw new IllegalArgumentException("No BankAccount instance");
        }
    }

    @Override
    public void doWork() {
        Thread t;
        if(HighVolumeAccount.class.isInstance(ba)) {
            t = new Thread((HighVolumeAccount) ba);
        } else {
            t = new Thread(this);
        }
        t.start();
    }

    @Override
    public void run() {

    }
}
