package com.bergaz.fundamentals.asynchronous.setupasync;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletionOfTwoTasks {
    public static void main(String[] args) {

        /**
         * RUNNABLE method: void (then)run(), cf method:thenRun()
         * CONSUMER method: void (then)accept(Long), cf method: thenAccept(); can take an object
         * FUNCTION method: User (then)apply(Long), cf thenApply(); can take object and can return object
         */

        /**
         * Different type CompletableFutures
         */
        CompletableFuture<List<Long>> cf1 = CompletableFuture.supplyAsync(() -> List.of(1L, 2L, 3L));

        CompletableFuture<MockUser> cf2 = CompletableFuture.supplyAsync(() -> new MockUser(1));

        /**
         * We wait for the both results become available
         */
        CompletableFuture<Void> cf3 =
                cf1.thenAcceptBoth(cf2, (list, mockUSer) -> System.out.println("INFO: list size:"+ list.size() +
                        " mock user id:" + mockUSer.getId()));

        cf3.join();

        /**
         * Multiple CompletableFutures
         */

        CompletableFuture<List<Long>> cf11 = CompletableFuture.supplyAsync(() -> List.of(1L, 2L, 3L));
        CompletableFuture<List<Long>> cf12 = CompletableFuture.supplyAsync(() -> List.of(11L, 12L, 13L));

        CompletableFuture<Void> cf13 =
                CompletableFuture.allOf(cf11, cf12);
    }
}
