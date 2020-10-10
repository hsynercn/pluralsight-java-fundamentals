package com.bergaz.intermediate.the_core_platform.section_08;

public class SyncBankAccount implements IBankAccount{
    private int balance;

    public SyncBankAccount(int balance) {
        this.balance = balance;
    }

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void deposit(int amount) {
        this.balance += amount;
    }
}
