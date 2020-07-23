package com.bergaz.streams;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;

public class WriteFormattedToStream {
    public static void main(String[] args) {
        doWrite(3999);
    }

    private static void doWrite(int number) {
        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get("C:/Pluralsight/pluralsight-java-fundamentals/Types/files/file_integer.txt"));
            Formatter f = new Formatter(writer);) {
            f.format("%d%n",number);
            f.format("% d%n",number);
            f.format("%+d%n",number);
            f.format("%(d%n",number);
            f.format("%10d%n",number);
            f.format("%010d%n",number);
            f.format("%,010d%n",number);
            f.format("%-10d%n",number);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
