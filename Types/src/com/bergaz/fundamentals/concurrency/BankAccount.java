package com.bergaz.fundamentals.concurrency;

public class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void deposit(int amount) {
        this.balance += amount;
    }

    public synchronized void withdrawal(int amount) {
        this.balance -= amount;
    }

    public void depositNotSync(int amount) {
        this.balance += amount;
    }
}
