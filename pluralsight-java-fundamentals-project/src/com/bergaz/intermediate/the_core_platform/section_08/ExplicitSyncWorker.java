package com.bergaz.intermediate.the_core_platform.section_08;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ExplicitSyncWorker implements Runnable {
    private Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);
    private IBankAccount account;

    public ExplicitSyncWorker(IBankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (account) {
                account.deposit(10);
            }
        }
    }
}
