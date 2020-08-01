package com.bergaz.fundamentals.core.concurrency;

public class RunnableWorkerSelfSync extends RunnableWorker{

    public RunnableWorkerSelfSync(BankAccount account) {
        super(account);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (account) {
                int startBalance = this.account.getBalance();
                account.depositNotSync(1);
                int endBalance = account.getBalance();
                System.out.println("Start: " + startBalance + " End: " + endBalance);
            }
        }
    }
}
