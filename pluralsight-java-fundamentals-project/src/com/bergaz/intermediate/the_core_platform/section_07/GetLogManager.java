package com.bergaz.intermediate.the_core_platform.section_07;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class GetLogManager {
    public static void main(String[] args) {
        LogManager logManager = LogManager.getLogManager();
        System.out.println(logManager);

        Enumeration<String> loggerNames = logManager.getLoggerNames();

        for (Iterator<String> it = loggerNames.asIterator(); it.hasNext(); ) {
            String name = it.next();
            System.out.println("Logger name: " + name);
        }

        System.out.println("Global logger name: " + Logger.GLOBAL_LOGGER_NAME);

        Logger logger = logManager.getLogger(Logger.GLOBAL_LOGGER_NAME);
    }
}
