package com.bergaz.intermediate.the_core_platform.section_08;

public class TxWorker implements Runnable {
    protected AdvancedBankAccount advancedBankAccount = null;
    protected char txType;
    protected int amt;

    public TxWorker(AdvancedBankAccount advancedBankAccount, char txType, int amt) {
        this.advancedBankAccount = advancedBankAccount;
        this.txType = txType;
        this.amt = amt;
    }

    /**
     * This flow just works fine, there wil be no problems with synchronized deposit and withdraw methods
     */

    @Override
    public void run() {
        if (txType == 'w') {
            advancedBankAccount.withdrawal(amt);
        } else if (txType == 'd') {
            advancedBankAccount.deposit(amt);
        }
    }
}
