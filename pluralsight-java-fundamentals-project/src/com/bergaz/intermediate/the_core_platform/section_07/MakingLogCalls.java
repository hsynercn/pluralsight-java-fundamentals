package com.bergaz.intermediate.the_core_platform.section_07;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class MakingLogCalls {
    static Logger logger2 = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static void main(String[] args) {
        LogManager logManager = LogManager.getLogManager();
        Logger logger = logManager.getLogger(Logger.GLOBAL_LOGGER_NAME);

        logger.log(Level.INFO, "My first message");
        logger2.log(Level.INFO, "My second message");
    }
}
