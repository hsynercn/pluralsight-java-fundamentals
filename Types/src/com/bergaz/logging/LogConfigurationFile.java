package com.bergaz.logging;

import java.util.logging.*;

/**
 * You can run this main from terminal with
 * java -Djava.util.logging.config.file=log.properties com.bergaz.logging.LogConfigurationFile
 * command and set log config properties externally
 */
public class LogConfigurationFile {
    static Logger logger = Logger.getLogger("com.bergaz");
    public static void main(String[] args) {
        logger.log(Level.INFO, "We are logging");
    }

    private static void configureLogger(){
        Handler h = new ConsoleHandler();
        h.setLevel(Level.ALL);
        h.setFormatter(new SimpleFormatter());
        logger.addHandler(h);
        logger.setLevel(Level.ALL);
        logger.info("We are logging");
    }
}
