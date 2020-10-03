package com.bergaz.intermediate.the_core_platform.section_03;

import java.io.*;

public class TryWithResources {
    public static void main(String[] args) {
        String inputFilePath = LocalFilePath.getPath() + "/input.txt";
        String outputFilePath = LocalFilePath.getPath() + "/output.txt";
        char[] buff = new char[8];
        int length;
        try (Reader reader = new FileReader(inputFilePath)) {
            while ((length = reader.read(buff)) >= 0) {
                System.out.print("\nLength: " + length + " ");
                for (int i = 0; i < length; i++) {
                    System.out.print(buff[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * We use writer.write(buff, 0, length) to write true buffer space
         */

        char[] chars = new char[8];
        try (Reader reader = new FileReader(inputFilePath);
        Writer writer = new FileWriter(outputFilePath)) {
            while ((length = reader.read(chars)) >= 0) {
                writer.write(chars, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("");

        try (MyAutoCloseable autoCloseable = new MyAutoCloseable()) {
            autoCloseable.sayHello();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
