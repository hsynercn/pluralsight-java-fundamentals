package com.bergaz.intermediate.the_core_platform.section_09;

import java.util.Arrays;

public class HighVolumeAccount extends BankAccount implements Runnable{
    private Integer[] dailyDeposits = {10, 20, 30};
    private Integer[] dailyWithdrawals = {1, 2, 3};

    public HighVolumeAccount(String id, int balance) {
        super(id, balance);
    }

    public HighVolumeAccount(String id) {
        super(id);
    }

    public Integer[] getDailyDeposits() {
        return dailyDeposits;
    }


    public Integer[] getDailyWithdrawals() {
        return dailyWithdrawals;
    }

    @Override
    public void run() {
        Arrays.asList(this.getDailyDeposits()).forEach(amount -> this.deposit(amount));
        Arrays.asList(this.getDailyWithdrawals()).forEach(amount -> this.withdraw(amount));
    }
}
