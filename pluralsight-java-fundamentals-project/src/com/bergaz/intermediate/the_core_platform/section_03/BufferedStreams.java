package com.bergaz.intermediate.the_core_platform.section_03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedStreams {
    public static void main(String[] args) {
        String inputFilePath = LocalFilePath.getPath() + "/input.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilePath))) {
            int intVal;
            while ((intVal = bufferedReader.read()) >= 0) {
                System.out.print((char) intVal);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
