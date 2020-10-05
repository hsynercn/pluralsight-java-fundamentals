package com.bergaz.intermediate.the_core_platform.section_06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class StorePropertiesAsSimpleText {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("name", "Hilly Billy");
        properties.setProperty("account", "123456789");

        String fileLOcation = LocalFilePath.getPath() + "/test.properties";

        try {
            properties.store(Files.newBufferedWriter(Paths.get(fileLOcation)), "This is my comment, whats up");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
