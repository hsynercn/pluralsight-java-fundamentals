package com.bergaz.fundamentals.iteration_one.core.concurrency;

public class RunnableWorkerNotSync extends RunnableWorker{
    public RunnableWorkerNotSync(BankAccount account) {
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
