package com.bergaz.fundamentals.iteration_one.moreobjectoriented.obsoletebooleanflags.goodimplementation.accountstates;

import com.bergaz.fundamentals.iteration_one.moreobjectoriented.obsoletebooleanflags.goodimplementation.AccountUnfrozen;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class Active implements AccountState {

    private AccountUnfrozen onUnfrozen;

    public Active(AccountUnfrozen onUnfrozen) {
        this.onUnfrozen = onUnfrozen;
    }

    @Override
    public AccountState deposit(BigDecimal amount, Consumer<BigDecimal> addToBalance) {
        addToBalance.accept(amount);
        return this;
    }

    @Override
    public AccountState withdraw(BigDecimal balance, BigDecimal amount,
                                 Consumer<BigDecimal> subtractFromBalance) {
        if (balance.compareTo(amount) > 0) {
            subtractFromBalance.accept(amount);
        }
        return this;
    }

    @Override
    public AccountState freezeAccount() {
        return new Frozen(this.onUnfrozen);
    }

    @Override
    public AccountState holderVerified() {
        return this;
    }

    @Override
    public AccountState closeAccount() {
        return new Closed();
    }
}