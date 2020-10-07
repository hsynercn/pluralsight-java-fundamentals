package com.bergaz.intermediate.the_core_platform.section_07;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class PreciseLogMethod {
    public static Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static void main(String[] args) {

        /**
         * Oct 07, 2020 8:50:46 PM this.is.some.shitty.class someMethod
         * SEVERE: it fcked up
         */

        logger.logp(Level.SEVERE, "this.is.some.shitty.class", "someMethod", "it fcked up");
    }
}
