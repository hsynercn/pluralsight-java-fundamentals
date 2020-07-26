package com.bergaz.concurrency;

import com.bergaz.calcengine.Adder;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableMain {
    public static void main(String[] main){
        String[] inFiles = {"C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\in_file1.txt",
                "C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\in_file2.txt",
                "C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\in_file3.txt",
                "C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\in_file4.txt",
                "C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\in_file5.txt",
                "C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\in_file6.txt"};
        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<Integer>[] results = new Future[inFiles.length];

        for(int i = 0; i < inFiles.length; i++) {
            CallableAdder callableAdder = new CallableAdder(inFiles[i]);
            results[i] = es.submit(callableAdder);
        }

        for(Future<Integer> result : results) {
            try {
                int value = result.get();
                System.out.println("Total:"+value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }
}
