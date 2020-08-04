package com.bergaz.fundamentals.asynchronous;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        ExecutorService service =
                Executors.newSingleThreadExecutor();
        Runnable task = () -> {
            for(int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Hello");
            }
        };
        Future future = service.submit(task);
        try {
            future.get();
            System.out.println("Service thread ended.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Runnable runnable = () -> {};
        Runnable loggingAMessage = () -> System.out.println("This is a log");

        //main thread execution
        runnable.run();

        //don't use this method, it is obsolete
        //Thread thread = new Thread();
        //thread.run(runnable);

        //use this method
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> future1 = executorService.submit(runnable);

        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(runnable);


        Supplier<String> supplier = () -> {
            System.out.println("Hello");
            return "Hello";
        };

        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(supplier);


        //give executor to completable future for runnable
        Runnable runnable1 = () -> System.out.println("Hello");
        ExecutorService service1 = Executors.newSingleThreadExecutor();
        Future<?> future2 = service1.submit(runnable1);
        CompletableFuture<Void> completableFuture2 =
                CompletableFuture.runAsync(runnable1, service1);

        //give executor to completable future for callable
        ExecutorService service2 = Executors.newSingleThreadExecutor();
        Supplier<String> stringSupplier = () -> {
            return "Hello";
        };
        CompletableFuture<String> stringCompletableFuture =
                CompletableFuture.supplyAsync(stringSupplier, service2);


    }
}
