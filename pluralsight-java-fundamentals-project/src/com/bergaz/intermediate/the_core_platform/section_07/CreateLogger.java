package com.bergaz.intermediate.the_core_platform.section_07;

import java.util.Formatter;
import java.util.logging.*;

public class CreateLogger {
    static Logger logger = Logger.getLogger("this.is.new");
    public static void main(String[] args) {
        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        SimpleFormatter formatter = new SimpleFormatter();
        handler.setFormatter(formatter);
        logger.addHandler(handler);
        logger.setLevel(Level.ALL);
        logger.log(Level.SEVERE, "SEVERE");
        logger.log(Level.WARNING, "WARNING");
        logger.log(Level.INFO, "INFO");
        logger.log(Level.CONFIG, "CONFIG");
        logger.log(Level.FINE, "FINE");
        logger.log(Level.FINER, "FINER");
        logger.log(Level.FINEST, "FINEST");
    }
}
