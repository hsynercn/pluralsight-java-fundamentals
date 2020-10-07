package com.bergaz.intermediate.the_core_platform.section_07;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ParameterizedMessageMethods {
    public static Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static void main(String[] args) {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);
        logger.setLevel(Level.ALL);
        logger.log(Level.INFO, "{0} is a parameterized string", "HELLO THERE");
        logger.log(Level.INFO, "{0} {2} and {1}", new Object[]{"ONE", "TWO", "THREE"});
        someMethod("NAMEnameNAME", 123.1234f, 98);
    }
    public static void someMethod(String name, float x, int y) {
        logger.entering("this.is.some.package.Class", "someMethod", new Object[]{name, x,y});
        logger.exiting("this.is.some.package.Class", "someMethod",
                String.format("result %s > %3$010f > %2$-5d", name, y, x));
    }
}
