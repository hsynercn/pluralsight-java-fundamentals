package com.bergaz.fundamentals.core.logging;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        LogManager lm = LogManager.getLogManager();
        Logger logger = lm.getLogger(Logger.GLOBAL_LOGGER_NAME);

        logger.log(Level.INFO, "This is the first log message");
        logger.log(Level.INFO, "Another log");

    }
}
