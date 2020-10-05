package com.bergaz.intermediate.the_core_platform.section_06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CmdLineFileReadExample {
    public static void main(String[] args) {
        if (args.length != 0) {
            String fileName = args[0];
            if(Files.exists(Paths.get(fileName))) {
                printFileLines(fileName);
            } else {
                System.out.println("File not found: " + fileName);
            }
        } else {
            System.out.println("Please provide an input.");
            return;
        }
    }

    public static void printFileLines(String fileLocation) {
        try {
            List<String> strings = Files.readAllLines(Paths.get(fileLocation));
            strings.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
