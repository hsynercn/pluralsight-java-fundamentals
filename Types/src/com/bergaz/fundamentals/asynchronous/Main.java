package com.bergaz.fundamentals.asynchronous;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
        executorService.submit(runnable);

    }
}
