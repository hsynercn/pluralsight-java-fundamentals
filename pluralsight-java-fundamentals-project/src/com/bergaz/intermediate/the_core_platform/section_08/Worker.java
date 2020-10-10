package com.bergaz.intermediate.the_core_platform.section_08;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Worker implements Runnable{
    private Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);
    private BankAccount account;

    public Worker(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int startBalance = this.account.getBalance();
            account.deposit(10);
            int endBalance = this.account.getBalance();
            logger.warning("start: " + startBalance + " end: " + endBalance);
        }
    }
}
