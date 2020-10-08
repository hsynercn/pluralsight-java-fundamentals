package com.bergaz.intermediate.the_core_platform.section_07.LoggerPackage;

import java.util.logging.Logger;

public class Student {
    static Logger logger = Logger.getLogger("com.bergaz.intermediate.the_core_platform.section_07.LoggerPackage.Student");
    public static void main(String[] args) {
        logger.severe("THIS IS A SEVERE LOG");
    }
}
