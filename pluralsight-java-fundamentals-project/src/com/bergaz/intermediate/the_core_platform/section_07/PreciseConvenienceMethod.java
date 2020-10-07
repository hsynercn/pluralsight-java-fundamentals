package com.bergaz.intermediate.the_core_platform.section_07;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class PreciseConvenienceMethod {
    public static Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static void main(String[] args) {
        logger.setLevel(Level.ALL);
        logger.entering("this.is.my.package", "doWork");
        logger.logp(Level.WARNING, "this.is.my.package", "doWork", "Empty Function");
        logger.exiting("this.is.my.package", "doWork");
    }
}
