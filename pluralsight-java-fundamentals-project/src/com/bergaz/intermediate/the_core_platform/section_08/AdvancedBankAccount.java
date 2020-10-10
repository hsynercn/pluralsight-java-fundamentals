package com.bergaz.intermediate.the_core_platform.section_08;

public class AdvancedBankAccount {
    private int balance;

    public AdvancedBankAccount(int balance) {
        this.balance = balance;
    }

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
    }

    public synchronized void withdrawal(int amount) {
        balance -= amount;
    }

}
