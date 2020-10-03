package com.bergaz.intermediate.the_core_platform.section_03;

import java.io.*;

public class BufferedStreamNewLine {
    public static void main(String[] args) {
        String[] data = {"Hello", "this", "is", "a", "buffered", "writer", "test"};
        String outputFilePath = LocalFilePath.getPath() + "/output_lines.txt";
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (String line : data) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("BufferedReader read lines:");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(outputFilePath))) {
            String inStr;
            while ((inStr = bufferedReader.readLine()) != null) {
                System.out.println(inStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
