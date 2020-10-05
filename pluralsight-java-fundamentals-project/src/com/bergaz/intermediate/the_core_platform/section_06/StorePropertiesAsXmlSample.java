package com.bergaz.intermediate.the_core_platform.section_06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class StorePropertiesAsXmlSample {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("name", "Hilly Billy");
        properties.setProperty("account", "987654321");

        String fileLocation = LocalFilePath.getPath() + "/test.xml";

        try {
            properties.storeToXML(Files.newOutputStream(Paths.get(fileLocation)), "This is a test xml property file");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
