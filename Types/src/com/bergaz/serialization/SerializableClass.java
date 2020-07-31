package com.bergaz.serialization;

import java.io.Serializable;

//can change from File -> Settings -> Editor -> Inspections -> Java -> Serialization issues:disable/enable severity:error
public class SerializableClass implements Serializable {
    private static final long serialVersionUID = 7113221516935585785L;
    private final String id;
    private int balance;
    private char lastTxType;
    private int lastTxAmount;

    public SerializableClass(String id) {
        this.id = id;
    }

    public SerializableClass(String id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public synchronized void deposit(int amount) {
        this.balance += amount;
        lastTxType = 'd';
        lastTxAmount = amount;
    }

    public synchronized void withdrawal(int amount) {
        this.balance -= amount;
        lastTxType = 'w';
        lastTxAmount = amount;
    }
}
