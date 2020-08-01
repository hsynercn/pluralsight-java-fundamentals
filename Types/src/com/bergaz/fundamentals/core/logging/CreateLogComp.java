package com.bergaz.fundamentals.core.logging;

import java.util.logging.*;

public class CreateLogComp {

    static Logger logger = Logger.getLogger("com.bergaz");

    public static void main(String[] args) {
        Handler h = new ConsoleHandler();
        h.setLevel(Level.ALL);
        SimpleFormatter f = new SimpleFormatter();

        h.setFormatter(f);

        logger.addHandler(h);
        logger.setLevel(Level.ALL);
        logger.log(Level.FINEST, "This is a generated logger");
    }
}
