package com.bergaz.fundamentals.asynchronous;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadSpecificExecution {
    public static void main(String[] args) {
        /**
         * Executed in common fork/joined pool
         */
        CompletableFuture<List<MockUser>> cf1 =
                CompletableFuture.supplyAsync(() -> List.of(1L, 2L, 3L))
                        .thenApply(list -> readUsers(list));

        /**
         * Executed in the provided pool of thread
         */
        Executor executor = Executors.newSingleThreadExecutor();
        CompletableFuture<List<Long>> cf2 =
                CompletableFuture.supplyAsync(() -> List.of(1L, 2L, 3L), executor);

        /**
         * Executed in the same thread
         */
        CompletableFuture<List<Long>> cf3 =
                CompletableFuture.supplyAsync(() -> List.of(1L, 2L, 3L));


    }

    private static List<MockUser> readUsers(List<Long> list) {
        ArrayList<MockUser> mockUsers = new ArrayList<>();
        for (long temp : list) {
            mockUsers.add(new MockUser(temp));
        }
        return mockUsers;
    }
}
