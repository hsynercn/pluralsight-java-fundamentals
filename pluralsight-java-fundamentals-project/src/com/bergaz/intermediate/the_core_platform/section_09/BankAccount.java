package com.bergaz.intermediate.the_core_platform.section_09;

public class BankAccount {
    private final String id;
    private int balance = 0;

    public BankAccount(String id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public BankAccount(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void deposit(int amount) {
        this.balance += amount;
    }

    public synchronized void withdraw(int amount) {
        this.balance -= amount;
    }
}
