package com.bergaz.intermediate.the_core_platform.section_06;

import com.bergaz.Main;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class LoadDefaultProperties {
    public static void main(String[] args) {
        Properties defaultProperties = new Properties();
        try(InputStream inputStream = LoadDefaultProperties.class.getResourceAsStream("my_default_values.xml")) {
            defaultProperties.loadFromXML(inputStream);
            System.out.println("DEFAULT:");
            defaultProperties.forEach((o, o2) -> System.out.println(o + " | " + o2));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String fileLoc = LocalFilePath.getPath() + "/user_props.xml";

        System.out.println("USER PROPS:");
        Properties userProperties = new Properties(defaultProperties);
        loadUserProps(fileLoc, userProperties);
        userProperties.forEach((o, o2) -> System.out.println(o + " | " + o2));

    }

    public static void loadUserProps(String fileLoc, Properties userProperties) {
        try {
            userProperties.loadFromXML(Files.newInputStream(Paths.get(fileLoc)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
