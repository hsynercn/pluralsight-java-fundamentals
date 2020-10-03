package com.bergaz.intermediate.the_core_platform.section_03;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class StreamExceptionHandling {
    public static void main(String[] main) {

        /**
         * This sample represents a troublesome stream flow, we can face an exception even at the stream creation step
         * and we have to solve this problem in finally block with a try catch anb null check
         */

        String inputFilePath = LocalFilePath.getPath() + "/input_does_not_exits.txt";

        System.out.println("Reader exception sample:");
        Reader reader = null;
        try {
            reader = new FileReader(inputFilePath);
            int intVal;
            while ((intVal = reader.read()) >= 0) {
                System.out.print((char) intVal);
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
