package com.bergaz.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        String[] inFiles = {"C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\in_file1.txt",
                "C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\in_file2.txt",
                "C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\in_file3.txt",
                "C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\in_file4.txt",
                "C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\in_file5.txt",
                "C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\in_file6.txt"};

        String[] outFiles = {"C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\out_file1.txt",
                "C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\out_file2.txt",
                "C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\out_file3.txt",
                "C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\out_file4.txt",
                "C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\out_file5.txt",
                "C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\out_file6.txt"};

        runMultiThread(inFiles, outFiles);
    }

    private static void runSingleThread(String[] inFiles, String[] outFiles) {
        for(int i = 0; i < inFiles.length; i++){
            Adder adder = new Adder(inFiles[i], outFiles[i]);
            adder.doAdd();
        }
    }

    private static void runMultiThread(String[] inFiles, String[] outFiles) {
        Thread[] threads = new Thread[inFiles.length];
        for(int i = 0; i < inFiles.length; i++){
            Adder adder = new Adder(inFiles[i], outFiles[i]);
            Thread thread = new Thread(adder);
            thread.start();
        }

        for(Thread thread:threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void threadPool(String[] inFiles, String[] outFiles) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        for (int i = 0; i < inFiles.length; i++) {
            Adder adder = new Adder(inFiles[i], outFiles[i]);
            es.submit(adder);
        }
        try{
            es.shutdown();
            es.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
