package com.bergaz.fundamentals.iteration_one.core.controlappexecution;

import java.io.InputStream;
import java.util.Properties;

public class DefaultValueLoad {
    public static void main(String[] args) {
        try{
            Properties defaultProperties = new Properties();
            try(InputStream inputStream = DefaultValueLoad.class.getResourceAsStream("MyDefaultValues.xml")) {
                defaultProperties.loadFromXML(inputStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
