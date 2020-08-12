package com.bergaz.fundamentals.asynchronous.chaintask;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
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
        ExecutorService executor1 = Executors.newSingleThreadExecutor();

        Supplier<List<Long>> supplyIDs = () -> {
            mySleep(200);
            return Arrays.asList(1L, 2L, 3L);
        };

        Function<List<Long>, CompletableFuture<List<User>>> fetchUsers = ids -> {
            mySleep(300);
            Supplier<List<User>> userSupplier =
                    () -> {
                        System.out.println("Currently running in " + Thread.currentThread().getName());
                        return ids.stream().map(User::new).collect(Collectors.toList());
                    };
            return CompletableFuture.supplyAsync(userSupplier);
        };

        Consumer<List<User>> displayer = users -> {
            System.out.println("Running in " + Thread.currentThread().getName());
            users.forEach(System.out::println);
        };

        CompletableFuture<List<Long>> completableFuture = CompletableFuture.supplyAsync(supplyIDs);
        completableFuture.thenComposeAsync(fetchUsers, executor1).thenAcceptAsync(displayer, executor);

        //completableFuture.join();
        mySleep(1000);
        executor.shutdown();
        executor1.shutdown();
    }

    public static void mySleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
