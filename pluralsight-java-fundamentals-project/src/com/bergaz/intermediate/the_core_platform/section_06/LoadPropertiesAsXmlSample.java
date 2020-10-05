package com.bergaz.intermediate.the_core_platform.section_06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class LoadPropertiesAsXmlSample {
    public static void main(String[] args) {
        Properties properties = new Properties();

        String fileLoc = LocalFilePath.getPath() + "/test.xml";

        try {
            properties.loadFromXML(Files.newInputStream(Paths.get(fileLoc)));
            properties.forEach((key, value) -> System.out.println(key + " | " + value));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
