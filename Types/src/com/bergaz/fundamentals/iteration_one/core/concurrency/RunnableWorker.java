package com.bergaz.fundamentals.iteration_one.core.concurrency;

public abstract class RunnableWorker implements Runnable{
    protected BankAccount account;

    public RunnableWorker(BankAccount account) {
        this.account = account;
    }

}
