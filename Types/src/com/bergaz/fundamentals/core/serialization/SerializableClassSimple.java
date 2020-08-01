package com.bergaz.fundamentals.core.serialization;

import java.io.Serializable;

//can change from File -> Settings -> Editor -> Inspections -> Java -> Serialization issues:disable/enable severity:error
public class SerializableClassSimple implements Serializable {
    private static final long serialVersionUID = -3745701150601206054L;
    private final String id;
    private int balance;

    public SerializableClassSimple(String id) {
        this.id = id;
    }

    public SerializableClassSimple(String id, int balance) {
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
    }

    public synchronized void withdrawal(int amount) {
        this.balance -= amount;
    }
}
