package com.bergaz.fundamentals.moreobjectoriented.obsoletebooleanflags.goodimplementation;

import java.math.BigDecimal;

public class Account {

    /**
     * Step by step complexity is leaking in our class
     * With every change out test case set is multiplying
     */
    private boolean isVerified;
    private boolean isClosed;
    private BigDecimal balance;
    private Freezable freezable;


    public Account(AccountUnfrozen accountUnfrozen) {
        this.balance = BigDecimal.ZERO;
        this.freezable = new FreezableActive(accountUnfrozen);
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
        this.freezable = this.freezable.freezeAccount();
    }

    public void deposit(BigDecimal amount) {
        if (this.isClosed) {
            return;
        }
        //Deposit money
        this.freezable = this.freezable.deposit();
        this.balance = this.balance.add(amount);
    }
    public void withdraw(BigDecimal amount) {
        if (!this.isVerified) {
            return;
        }
        if (this.isClosed) {
            return;
        }
        this.freezable = this.freezable.withdraw();
        this.balance = this.balance.subtract(amount);
    }

}
