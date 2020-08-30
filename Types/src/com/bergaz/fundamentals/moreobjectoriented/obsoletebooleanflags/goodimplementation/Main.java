package com.bergaz.fundamentals.moreobjectoriented.obsoletebooleanflags.goodimplementation;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        AccountUnfrozen printerAccountUnfrozen = new PrinterAccountUnfrozen();
        Account account = new Account(printerAccountUnfrozen);
        account.deposit(new BigDecimal(10));
    }
}
