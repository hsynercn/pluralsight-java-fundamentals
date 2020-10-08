package com.bergaz.intermediate.the_core_platform.section_08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;

public class MyAdder {
    private String inFile, outFile;

    public MyAdder(String inFile, String outFile) {
        this.inFile = inFile;
        this.outFile = outFile;
    }

    public void doAdd() {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(inFile));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(outFile), StandardOpenOption.CREATE_NEW)) {
            int total = 0;
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                total += Integer.parseInt(line);
            }
            bufferedWriter.write(Integer.toString(total));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
