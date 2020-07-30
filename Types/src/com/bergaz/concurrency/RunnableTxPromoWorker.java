package com.bergaz.concurrency;

public class RunnableTxPromoWorker extends RunnableTxWorker {
    public RunnableTxPromoWorker(BankAccount account, char txType, int amt) {
        super(account, txType, amt);
    }

    @Override
    public void run() {
        if (txType == 'w')
            account.withdrawal(amt);
        else if (txType == 'd') {
            synchronized (account) {
                account.deposit(amt);
                if (account.getBalance() > 500) {
                    int bonus = (int) ((account.getBalance() - 500) * 0.01);
                    account.deposit(bonus);
                }

            }
        }
    }
}
