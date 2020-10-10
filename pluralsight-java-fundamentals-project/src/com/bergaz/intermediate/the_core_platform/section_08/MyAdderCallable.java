package com.bergaz.intermediate.the_core_platform.section_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

public class MyAdderCallable implements Callable<Integer> {

    private String inFile;

    public MyAdderCallable(String inFile) {
        this.inFile = inFile;
    }

    @Override
    public Integer call() throws Exception {
        return doAdd();
    }

    private int doAdd() throws IOException {
        int sum = 0;
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(inFile))) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                sum += Integer.parseInt(line);
            }
        }
        return sum;
    }
}
