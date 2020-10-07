package com.bergaz.intermediate.the_core_platform.section_07;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class SimpleLogMethod {
    public static Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static void main(String[] args) {

        /**
         * Oct 07, 2020 8:33:46 PM com.bergaz.intermediate.the_core_platform.section_07.SimpleLogMethod logThisMethod
         * SEVERE: This is a severe log message
         *
         * We get upper log text from this method, with simple log method we get date, caller class and method name
         */

        logThisMethod();

    }
    public static void logThisMethod() {
        logger.log(Level.SEVERE, "This is a severe log message");
    }
}
