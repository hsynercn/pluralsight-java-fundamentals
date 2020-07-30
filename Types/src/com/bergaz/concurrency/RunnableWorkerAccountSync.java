package com.bergaz.concurrency;

public class RunnableWorkerAccountSync extends RunnableWorker{
    public RunnableWorkerAccountSync(BankAccount account) {
        super(account);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (account) {
                int startBalance = this.account.getBalance();
                account.deposit(1);
                int endBalance = account.getBalance();
                System.out.println("Start: " + startBalance + " End: " + endBalance);
            }
        }
    }
}