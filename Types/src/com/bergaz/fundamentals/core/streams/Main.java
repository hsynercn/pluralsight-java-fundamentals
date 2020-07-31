package com.bergaz.fundamentals.core.streams;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //doTryCatchFinally();
        //doTryWithResources();
        //doCloseThing();
        try {
            readData("C:/Pluralsight/pluralsight-java-fundamentals/Types/files/file.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readExamples() {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\file.txt");

            int intVal;
            while ((intVal = inputStream.read()) >= 0) {
                byte byteVal = (byte) intVal;
                System.out.print(String.format("%X",byteVal));
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n\n");

        try {
            Reader reader = new FileReader("C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\file.txt");

            int intVal;

            while ((intVal = reader.read()) >= 0) {
                System.out.print((char)intVal);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void doTryCatchFinally() {
        char[] buff = new char[8];
        int length;
        Reader reader = null;
        try {
            reader = Helper.openReader("C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\file.txt");

            while ((length = reader.read(buff)) >= 0) {
                System.out.println("\nlength:" + length);
                for(int i = 0; i < length; i++) {
                    System.out.println(buff[i]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void doTryWithResources() {
        char[] buff = new char[8];
        int length;
        try (Reader reader = Helper.openReader("C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\file.txt");
             Writer writer = Helper.openWriter("C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\file-copy.txt")) {
            while ((length = reader.read(buff)) >= 0) {
                System.out.println("\nlength:" + length);
                writer.write(buff, 0, length);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void doCloseThing() {
        try(MyAutoCloseable ac = new MyAutoCloseable()) {
            ac.saySomething();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void doChain(InputStream in) throws IOException {
        int length;
        char[] charBuff = new char[128];
        try(InputStreamReader rdr = new InputStreamReader(in);) {
            while ((length = rdr.read(charBuff)) >= 0) {
                System.out.println(charBuff);
            }
        }
    }

    private static void readData(String path) throws IOException {
        try(BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            String inValue;
            while((inValue = br.readLine()) != null) {
                System.out.println(inValue);
            }
        }
    }

    private static void readThemAll(String path) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(path));
        for(String line : lines) {
            System.out.println(line);
        }
    }
}
