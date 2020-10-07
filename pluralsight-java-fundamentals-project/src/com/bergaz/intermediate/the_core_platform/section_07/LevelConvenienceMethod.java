package com.bergaz.intermediate.the_core_platform.section_07;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LevelConvenienceMethod {
    public static Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static void main(String[] args) {

        /**
         * Oct 07, 2020 8:42:07 PM com.bergaz.intermediate.the_core_platform.section_07.LevelConvenienceMethod main
         * SEVERE: severe
         */

        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");

    }
}
