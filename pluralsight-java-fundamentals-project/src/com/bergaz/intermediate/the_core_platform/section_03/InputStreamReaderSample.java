package com.bergaz.intermediate.the_core_platform.section_03;

import java.io.*;

public class InputStreamReaderSample {
    public static void main(String[] args) {
        String inputFilePath = LocalFilePath.getPath() + "/input.txt";

        /**
         * Higher level stream close also closes the lower level stream
         */

        try (InputStream inputStream = new FileInputStream(inputFilePath);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream)) {
            int length;
            char[] charBuff = new char[128];
            while ((length = inputStreamReader.read(charBuff)) >= 0) {
                System.out.println(charBuff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
