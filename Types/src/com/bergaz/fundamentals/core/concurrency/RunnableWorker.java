package com.bergaz.fundamentals.core.concurrency;

public abstract class RunnableWorker implements Runnable{
    protected BankAccount account;

    public RunnableWorker(BankAccount account) {
        this.account = account;
    }

}
