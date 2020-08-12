package com.bergaz.fundamentals.asynchronous.setupasync;

import java.util.concurrent.CompletableFuture;

public class SimpleCompletableFuture {
    public static void main(String[] args) throws InterruptedException {

        //we can create a cf with new constructor
        CompletableFuture<Void> cf = new CompletableFuture<>();

        //but we need to it's complete method to end it, we can use this property for task chaining
        Runnable task = () -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cf.complete(null);
        };

        CompletableFuture.runAsync(task);

        Void nil = cf.join();

    }
}
