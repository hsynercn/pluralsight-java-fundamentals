package com.bergaz.fundamentals.iteration_one.asynchronous.performant;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class TriggerExample {
    public static void main(String[] args) {

        Executor executor = Executors.newSingleThreadExecutor();

        Supplier<List<Long>> supplyIDs = () -> {
            mySleep(200);
            return Arrays.asList(1L, 2L, 3L);
        };

        Function<List<Long>, List<User>> fetchUsers = ids -> {
            mySleep(300);
            return ids.stream().map(User::new).collect(Collectors.toList());
        };

        Consumer<List<User>> displayer = users -> {
            System.out.println("In thread " + Thread.currentThread().getName());
            users.forEach(System.out::println);
        };

        CompletableFuture<Void> start = new CompletableFuture<>();

        CompletableFuture<List<Long>> supply = start.thenApply(nil -> supplyIDs.get());
        CompletableFuture<List<User>> fetch = supply.thenApply(fetchUsers);
        CompletableFuture<Void> display = fetch.thenAccept(displayer);

        start.completeAsync(() -> null, executor);

        System.out.println("Main thread completed");

        mySleep(1_000);
    }

    public static void mySleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
