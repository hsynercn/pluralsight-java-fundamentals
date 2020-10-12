package com.bergaz.intermediate.the_core_platform.section_09;

public class AccountWorker implements Runnable{
    private BankAccount bankAccount;
    private HighVolumeAccount highVolumeAccount;

    public AccountWorker(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public AccountWorker(HighVolumeAccount highVolumeAccount) {
        this.highVolumeAccount = highVolumeAccount;
    }

    @Override
    public void run() {
        char txType = 'w';
        int amt = 50;
        if (txType == 'w') {
            bankAccount.withdraw(amt);
        } else {
            bankAccount.deposit(amt);
        }
    }

    public void doWork() {
        Thread t = new Thread(highVolumeAccount != null ? highVolumeAccount : this);
        t.start();
    }
}
