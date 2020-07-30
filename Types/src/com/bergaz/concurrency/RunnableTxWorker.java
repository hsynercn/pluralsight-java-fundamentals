package com.bergaz.concurrency;

public class RunnableTxWorker extends RunnableWorker {
    protected char txType;
    protected int amt;

    public RunnableTxWorker(BankAccount account, char txType, int amt) {
        super(account);
        this.txType = txType;
        this.amt = amt;
    }

    @Override
    public void run() {
        if (txType == 'w')
            account.withdrawal(amt);
        else if (txType == 'd')
            account.deposit(amt);
    }
}
