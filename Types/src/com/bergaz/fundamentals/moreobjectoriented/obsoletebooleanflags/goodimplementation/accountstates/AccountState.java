package com.bergaz.fundamentals.moreobjectoriented.obsoletebooleanflags.goodimplementation.accountstates;

import java.math.BigDecimal;
import java.util.function.Consumer;

public interface AccountState {
    AccountState deposit(BigDecimal amount, Consumer<BigDecimal> addToBalance);
    AccountState withdraw(BigDecimal balance, BigDecimal amount,
                          Consumer<BigDecimal> subtractFromBalance);
    AccountState freezeAccount();
    AccountState holderVerified();
    AccountState closeAccount();
}
