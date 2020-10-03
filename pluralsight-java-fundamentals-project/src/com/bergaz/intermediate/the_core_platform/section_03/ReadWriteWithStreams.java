package com.bergaz.intermediate.the_core_platform.section_03;

import java.io.*;

public class ReadWriteWithStreams {
    public static void main(String[] args) throws IOException {
        

        String inputFilePath = LocalFilePath.getPath() + "/input.txt";

        String outputFilePath = LocalFilePath.getPath() + "/output.txt";


        InputStream input = new FileInputStream(inputFilePath);
        int intVal;
        System.out.println("Byte:");
        while ((intVal = input.read()) >= 0) {
            byte byteVal = (byte) intVal;
            System.out.println(byteVal);
        }

        System.out.println("Char:");
        Reader reader = new FileReader(inputFilePath);
        while ((intVal = reader.read()) >= 0) {
            char charVal = (char) intVal;
            System.out.println(charVal);
        }

        InputStream inputStream = new FileInputStream(inputFilePath);
        int length;

        byte[] byteBuff = new byte[10];

        System.out.println("Read byte with buffer:");
        while ((length = inputStream.read(byteBuff)) >= 0) {
            System.out.println("Byte buffer array:");
            for (int i=0; i < length; i++) {
                byte byteVal = byteBuff[i];
                System.out.println(byteVal);
            }
        }

        Reader fileReader = new FileReader(inputFilePath);
        char[] charBuffer = new char[10];

        System.out.println("Read char with buffer:");
        while ((length = fileReader.read(charBuffer)) >= 0) {
            System.out.println("Char buffer array:");
            for (int i= 0; i < length; i++) {
                char charVal = charBuffer[i];
                System.out.println(charVal);
            }
        }

        OutputStream outputStream = new FileOutputStream(outputFilePath);
        byte outByteVal = 100;
        outputStream.write(outByteVal);

        byte[] outByteBuff = {3, 55, -12};
        outputStream.write(outByteBuff);

        Writer writer = new FileWriter(outputFilePath);
        char ch = 's';
        writer.write(ch);
        char[] charBuff = {'a', 'b', 'c'};
        writer.write(charBuff);
        String stringVal = "Hello";
        writer.write(stringVal);

    }
}

