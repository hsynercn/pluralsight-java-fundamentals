package com.bergaz.intermediate.the_core_platform.section_08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyAdderExecutorServiceCallable {
    public static void main(String[] args) {
        String[] inFiles = {
                "in_integers_1.txt", "in_integers_2.txt",
                "in_integers_3.txt", "in_integers_4.txt",
                "in_integers_5.txt", "in_integers_6.txt"};
        String inFolder = LocalFilePath.getPath() + "/in_files/";

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ArrayList<Future> futures = new ArrayList<>();
        Arrays.asList(inFiles).forEach(inFile -> {
            MyAdderCallable myAdderCallable = new MyAdderCallable(inFolder + inFile);
            Future<Integer> submit = executorService.submit(myAdderCallable);
            futures.add(submit);
        });

        futures.forEach(future -> {
            try {
                System.out.println("Result: " + future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
                System.out.println(e.getCause());
            }
        });

    }
}
