package com.bergaz.intermediate.the_core_platform.section_06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class LoadPropertiesFromSimpleText {
    public static void main(String[] args) {
        Properties properties = new Properties();

        String fileLocation = LocalFilePath.getPath() + "/test_load.properties";

        try {
            properties.load(Files.newBufferedReader(Paths.get(fileLocation)));
            properties.forEach((key, value) -> System.out.println(key + " | " + value));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
