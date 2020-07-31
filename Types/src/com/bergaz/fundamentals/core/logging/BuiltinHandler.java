package com.bergaz.fundamentals.core.logging;

import java.io.IOException;
import java.util.logging.*;

public class BuiltinHandler {
    static Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static void main(String[] args) throws IOException {
        FileHandler h = new FileHandler("%h/myapp_%g.log", 1000, 4);
        h.setFormatter(new SimpleFormatter());
        logger.addHandler(h);

        while(true)
            logger.log(Level.SEVERE, "This takes space");
    }
}
