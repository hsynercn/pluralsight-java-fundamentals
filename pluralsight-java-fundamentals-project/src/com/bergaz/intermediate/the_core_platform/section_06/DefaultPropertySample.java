package com.bergaz.intermediate.the_core_platform.section_06;

import java.util.Properties;

public class DefaultPropertySample {
    public static void main(String[] args) {
        Properties defaults = new Properties();
        defaults.setProperty("position", "1");

        Properties properties = new Properties(defaults);

        int val = Integer.parseInt(properties.getProperty("position"));

        properties.setProperty("position", Integer.toString(val + 100));

        System.out.println("position : " + properties.getProperty("position"));
    }
}
