package com.bergaz.fundamentals.asynchronous;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class TriggerTaskFromTask {
    public static void main(String[] args) {
        CompletableFuture<List<MockUser>> cf2 = CompletableFuture.supplyAsync(() -> List.of(1L, 2L, 3L))
                .thenApply(list -> readUsers(list));

        Function<List<Long>, List<MockUser>> mapper =
                list -> readUsers(list);

    }

    private static List<MockUser> readUsers(List<Long> list) {
        ArrayList<MockUser> mockUsers = new ArrayList<>();
        for (long temp : list) {
            mockUsers.add(new MockUser(temp));
        }
        return mockUsers;
    }
}
