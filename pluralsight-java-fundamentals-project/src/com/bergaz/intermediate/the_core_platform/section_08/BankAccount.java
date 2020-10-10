package com.bergaz.intermediate.the_core_platform.section_08;

public class BankAccount implements IBankAccount{
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }
}
