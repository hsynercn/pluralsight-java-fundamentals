package com.bergaz.fundamentals.iteration_one.core.controlappexecution;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class StoreProperties {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("displayName", "Hello World");
        properties.setProperty("account", "213-33-444");

        try(Writer writer = Files.newBufferedWriter(Paths.get("C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\test.properties"))) {
            properties.store(writer, "This is a comment");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(OutputStream outputStream = Files.newOutputStream(Paths.get("C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\test.xml"))) {
            properties.storeToXML(outputStream, "This is a comment");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Properties properties1 = new Properties();
        try(Reader reader = Files.newBufferedReader(Paths.get("C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\test.properties"))) {
            properties1.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(String name : properties.stringPropertyNames()) {
            System.out.println(name + ">" + properties.getProperty(name));
        }

        Properties properties2 = new Properties();
        try(InputStream inputStream = Files.newInputStream(Paths.get("C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\test.xml"))) {
            properties2.loadFromXML(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(String name : properties2.stringPropertyNames()) {
            System.out.println(name + ">" + properties.getProperty(name));
        }

    }
}
