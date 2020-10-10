package com.bergaz.intermediate.the_core_platform.section_08;

public class TxPromoWorker extends TxWorker {

    private final int bonusThreshold = 500;
    private final float bonusRatio = 0.1f;

    public TxPromoWorker(AdvancedBankAccount advancedBankAccount, char txType, int amt) {
        super(advancedBankAccount, txType, amt);
    }

    @Override
    public void run() {
        if (txType == 'w') {
            advancedBankAccount.withdrawal(amt);
        } else if (txType == 'd') {
            synchronized (advancedBankAccount) {
                advancedBankAccount.deposit(amt);
                if (advancedBankAccount.getBalance() > 500) {
                    advancedBankAccount.deposit((int)(advancedBankAccount.getBalance() * bonusRatio));
                }
            }
        }
    }
}
