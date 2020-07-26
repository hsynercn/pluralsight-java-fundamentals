package com.bergaz.concurrency;

public class RunnableWorker implements Runnable{
    private BankAccount account;

    public RunnableWorker(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            int startBalance = account.getBalance();
            account.deposit(1);
            int endBalance = account.getBalance();
            System.out.println("Start: " + startBalance + " End: " + endBalance);
        }
    }
}
