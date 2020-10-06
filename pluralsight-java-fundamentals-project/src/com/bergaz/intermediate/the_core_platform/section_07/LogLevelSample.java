package com.bergaz.intermediate.the_core_platform.section_07;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LogLevelSample {
    static Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static void main(String[] args) {
        logger.setLevel(Level.FINE);
        logger.log(Level.SEVERE, "SEVERE");
        logger.log(Level.WARNING, "WARNING");
        logger.log(Level.INFO, "INFO");
        logger.log(Level.CONFIG, "CONFIG");
        logger.log(Level.FINE, "FINE");
        logger.log(Level.FINER, "FINER");
        logger.log(Level.FINEST, "FINEST");
    }
}
