package com.bergaz.intermediate.the_core_platform.section_07;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggingWithFileHandler {
    static Logger logger = Logger.getLogger("com.bergaz.intermediate.the_core_platform.section_07");
    public static void main(String[] arg) throws IOException {
        FileHandler fileHandler = new FileHandler("%h/thisapp_%g.log", 1000, 4);
        fileHandler.setFormatter(new SimpleFormatter());
        fileHandler.setLevel(Level.ALL);
        logger.addHandler(fileHandler);
        logger.setLevel(Level.ALL);

        logger.fine("This is a fine message");

    }
}
