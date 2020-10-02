package com.bergaz.fundamentals.iteration_one.moreobjectoriented.obsoletebooleanflags.badimplementation;

import java.math.BigDecimal;

public class Account {

    /**
     * Step by step complexity is leaking in our class
     * With every change out test case set is multiplying
     */
    private boolean isVerified;
    private boolean isClosed;
    private boolean isFrozen;
    private BigDecimal balance;
    private AccountUnfrozen onUnfrozen;

    public Account(AccountUnfrozen accountUnfrozen) {
        this.balance = BigDecimal.ZERO;
        this.onUnfrozen = accountUnfrozen;
    }

    public void helderVerified() {
        this.isVerified = true;
    }

    public void closeAccount() {
        this.isClosed = true;
    }

    public void freezeAccount() {
        if (!this.isVerified) {
            return;
        }
        if (this.isClosed) {
            return;
        }
        this.isFrozen = true;
    }

    public void deposit(BigDecimal amount) {
        if (this.isClosed) {
            return;
        }
        //Deposit money
        if (this.isFrozen) {
            this.isFrozen = false;
            this.onUnfrozen.handle();
        }
        this.balance = this.balance.add(amount);
    }
    public void withdraw(BigDecimal amount) {
        if (!this.isVerified) {
            return;
        }
        if (this.isClosed) {
            return;
        }
        if (this.isFrozen) {
            this.isFrozen = false;
            this.onUnfrozen.handle();
        }
        //Withdraw money
        this.balance = this.balance.subtract(amount);
    }
}
