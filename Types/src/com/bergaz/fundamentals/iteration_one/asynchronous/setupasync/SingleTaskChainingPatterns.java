package com.bergaz.fundamentals.iteration_one.asynchronous.setupasync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class SingleTaskChainingPatterns {
    public static void main(String[] args) {
        CompletableFuture<Void> cf =
                CompletableFuture.runAsync(() -> updateDb())
                        .thenRun(() -> System.out.println("Update done"))
                        .thenAccept(value -> System.out.println("Consumer Value:" + value));
        /**
         * This chain example is not a logical one, only accessible value is null for consumer
         */

        CompletableFuture<List<MockUser>> cf1 =
                CompletableFuture.supplyAsync(() -> List.of(1L, 2L, 3L))
                        .thenApply(list -> readUsers(list));

        CompletableFuture<Void> cf2 =
                CompletableFuture.supplyAsync(() -> List.of(1L, 2L, 3L))
                        .thenApply(list -> readUsers(list))
                        .thenAccept(list -> list.forEach(MockUser::printInfo));
        cf.join();
        cf1.join();
        cf2.join();
    }

    private static void updateDb() {
        System.out.println("I am updating the db");
    }

    private static List<MockUser> readUsers(List<Long> list) {
        ArrayList<MockUser> mockUsers = new ArrayList<>();
        for (long temp : list) {
            mockUsers.add(new MockUser(temp));
        }
        return mockUsers;
    }
}
