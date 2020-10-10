package com.bergaz.intermediate.the_core_platform.section_08;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolAdder {
    public static void main() {
        String[] inFiles = {
                "in_integers_1.txt", "in_integers_2.txt",
                "in_integers_3.txt", "in_integers_4.txt",
                "in_integers_5.txt", "in_integers_6.txt"};
        String inFolder = LocalFilePath.getPath() + "/in_files/";
        String outFolder =  LocalFilePath.getPath() + "/out_files/";

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Arrays.asList(inFiles).forEach(inFile -> {
            MyAdderRunnable myAdderRunnable = new MyAdderRunnable(inFolder + inFile, outFolder + "out_" + inFile);
            executorService.submit(myAdderRunnable);
        });

        try {
            executorService.shutdown();
            executorService.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
