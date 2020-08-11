package com.bergaz.fundamentals.asynchronous;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MyChainExample {
    public static void main(String[] args) {
        CompletableFuture cf = CompletableFuture.supplyAsync(() -> List.of(1L, 2L, 3L))
                .thenApply(list -> {
                    System.out.println(list);
                    return list;
                });

        cf.thenRun(() -> System.out.println("The list of users has been read"));
        boolean test = false;
        cf.thenAccept(myVal -> System.out.println(myVal));

        /**
         * RUNNABLE method: void (then)run(), cf method:thenRun()
         * CONSUMER method: void (then)accept(Long), cf method: thenAccept(); can take an object
         * FUNCTION method: User (then)apply(Long), cf thenApply(); can take object and can return object
         */
    }
}
