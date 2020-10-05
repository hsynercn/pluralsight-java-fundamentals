package com.bergaz.intermediate.the_core_platform.section_06;

import java.util.Hashtable;
import java.util.Properties;

public class PropertiesClassSample {
    public static void main(String[] args) {
        Properties properties = new Properties();

        properties.setProperty("displayName", "Hilly Billy");
        String value1 = properties.getProperty("displayName");
        String value2 = properties.getProperty("nonSet");
        String value3 = properties.getProperty("nonSet", "Empty");
        System.out.println(String.format("Set value: %s Not set: %s Default: %s", value1, value2, value3));
    }
}
