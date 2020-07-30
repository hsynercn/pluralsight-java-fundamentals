package com.bergaz.reflection;

public class HighVolumeAccount extends BankAccount implements Runnable{
    public HighVolumeAccount(String id) {
        super(id);
    }

    public HighVolumeAccount(String id, int balance) {
        super(id, balance);
    }

    private int[] readDailyDeposits() {
        return null;
    }

    private int[] readDailyWithdrawals() {
        return null;
    }


    @Override
    public void run() {

    }
}
