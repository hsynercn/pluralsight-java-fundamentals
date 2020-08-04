package com.bergaz.fundamentals.asynchronous;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class CompletableFutureWithSupplier {
    public static void main(String[] args) {
        //runSupplier();
        //runSupplierWithWait();
        runSupplierWithForcedComplete();
    }

    private static void runSupplierWithForcedComplete() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Supplier<String> supplier = () -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Thread.currentThread().getName();
        };

        //This thread is from pool-1-thread-*
        CompletableFuture<String> completableFuture =
                CompletableFuture.supplyAsync(supplier, executor);


        String string = completableFuture.join();
        System.out.println("Result: " + string);

        completableFuture.complete("Too long!");

        string = completableFuture.join();
        System.out.println("Result after complete: " + string);

        //Obtrude value overrides the previous result
        completableFuture.obtrudeValue("Too long");

        string = completableFuture.join();
        System.out.println("Result after complete: " + string);

        executor.shutdown();
    }

    private static void runSupplierWithWait() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Supplier<String> supplier = () -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Supplier thread: " + Thread.currentThread().getName());
            return Thread.currentThread().getName();
        };

        //This thread is from pool-1-thread-*
        CompletableFuture<String> completableFuture =
                CompletableFuture.supplyAsync(supplier, executor);
        /**
         *  With providing an ExecutorService to runAsync we can prevent main thread from exiting. But in this case we
         *  need to shutdown the executor manually, otherwise main thread can't exit. Shutdown executes all submitted
         *  tasks.
         */
        executor.shutdown();
    }

    private static void runSupplier() {
        Supplier<String> supplier = () -> Thread.currentThread().getName();

        //This thread is from ForkJoinPool.commonPool
        CompletableFuture<String> completableFuture =
                CompletableFuture.supplyAsync(supplier);

        //If we don't call join deamon thread can't get the change for print, main thread exits before print
        String string = completableFuture.join();
        System.out.println("Result: " + string);
    }
}
