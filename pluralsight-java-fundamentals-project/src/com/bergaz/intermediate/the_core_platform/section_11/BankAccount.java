package com.bergaz.intermediate.the_core_platform.section_11;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class BankAccount implements Serializable {

    private static final long serialVersionUID = -5185492362356713418L;

    /**
     * String type is serializable
     */
    private String id;
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

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = objectInputStream.readFields();
        this.id = (String) fields.get("id", null);
        this.balance = fields.get("balance", 0);
        this.lastTxType = fields.get("lastTxType", 'u');
        this.lastTxAmount = fields.get("lastTxAmount", -1);

    }
}
