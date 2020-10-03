package com.bergaz.fundamentals.iteration_one.core.logging;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ClassLevelMain {
    static Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static void main(String[] args) {

        logger.setLevel(Level.ALL);

        logger.log(Level.INFO, "This is the first log message");
        logger.log(Level.INFO, "Another log");

        logger.log(Level.SEVERE, "SEVERE");
        logger.log(Level.WARNING, "WARNING");
        logger.log(Level.INFO,"INFO");
        logger.log(Level.CONFIG, "CONFIG");
        logger.log(Level.FINE, "FINE");
        logger.log(Level.FINER, "FINER");
        logger.log(Level.FINEST, "FINEST");

        doWork();

    }
    public static void doWork() {
        logger.entering("com.bergaz.logging.ClassLevelMain", "doWork");
        logger.logp(Level.WARNING,"com.bergaz.logging.ClassLevelMain", "doWork", "empty function");
        logger.exiting("com.bergaz.logging.ClassLevelMain", "doWork");
    }
}
