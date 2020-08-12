package com.bergaz.fundamentals.asynchronous.notes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;

public class CompletableFutureComposition {
    public static void main(String[] args) {
        Supplier<List<Long>> userIdsSupplier =
                () -> remoteService();
        Function<List<Long>, List<MockUser>> usersFromIds =
                ids -> readUsers(ids);

        CompletableFuture<List<MockUser>> cf =
                CompletableFuture.supplyAsync(userIdsSupplier)
                .thenApply(usersFromIds);


        Supplier<List<Long>> userIdsSupplier1 =
                () -> remoteService();

        CompletableFuture<String> cf1 =
                CompletableFuture.supplyAsync(userIdsSupplier1)
                        .thenCompose(s -> CompletableFuture.supplyAsync(() -> "Parameter: " + s.toString()));


    }


    private static List<Long> remoteService() {
        return List.of(1L, 2L, 3L);
    }
    private static List<MockUser> readUsers(List<Long> list) {
        ArrayList<MockUser> mockUsers = new ArrayList<>();
        for (long temp : list) {
            mockUsers.add(new MockUser(temp));
        }
        return mockUsers;
    }
}
