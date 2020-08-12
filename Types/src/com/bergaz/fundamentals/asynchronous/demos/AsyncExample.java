package com.bergaz.fundamentals.asynchronous.demos;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.lang.Thread.sleep;

public class AsyncExample {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Supplier<List<Long>> supplyIDs = () -> {
            mySleep(200);
            return Arrays.asList(1L, 2L, 3L);
        };

        Function<List<Long>, List<User>> fetchUsers = ids -> {
            mySleep(300);
            return ids.stream().map(User::new).collect(Collectors.toList());
        };

        Consumer<List<User>> displayer = users -> {
            System.out.println("Running in " + Thread.currentThread().getName());
            users.forEach(System.out::println);
        };

        CompletableFuture<List<Long>> completableFuture = CompletableFuture.supplyAsync(supplyIDs);
        completableFuture.thenApply(fetchUsers).thenAcceptAsync(displayer, executor);

        completableFuture.join();
        executor.shutdown();
    }

    public static void mySleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
