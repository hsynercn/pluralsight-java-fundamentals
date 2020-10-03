package com.bergaz.intermediate.the_core_platform.section_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadingLinesWithFiles {
    public static void main(String[] args) {
        String inputFilePath = LocalFilePath.getPath() + "/input.txt";
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(inputFilePath))) {
            String inString;
            while ((inString = bufferedReader.readLine()) != null) {
                System.out.println(inString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            List<String> lines = Files.readAllLines(Paths.get(inputFilePath));
            System.out.println("Files real all lines:");
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
