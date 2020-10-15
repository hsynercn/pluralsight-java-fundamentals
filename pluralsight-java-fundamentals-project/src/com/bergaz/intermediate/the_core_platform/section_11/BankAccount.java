package com.bergaz.intermediate.the_core_platform.section_11;

import java.io.Serializable;

public class BankAccount implements Serializable {
    /**
     * String type is serializable
     */
    private final String id;
    /**
     * All primitives are serializable
     */
    private int balance = 0;

    private char lastTxType;
    private int lastTxAmount;

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
        lastTxType = 'd';
        lastTxAmount = amount;
    }

    public synchronized void withdraw(int amount) {
        this.balance -= amount;
        lastTxType = 'w';
        lastTxAmount = amount;
    }
}
