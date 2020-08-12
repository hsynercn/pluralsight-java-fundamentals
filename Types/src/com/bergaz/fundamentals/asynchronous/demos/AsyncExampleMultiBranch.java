package com.bergaz.fundamentals.asynchronous.demos;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static com.bergaz.fundamentals.asynchronous.demos.AsyncExample.mySleep;

public class AsyncExampleMultiBranch {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Supplier<List<Long>> supplyIDs = () -> {
            mySleep(200);
            return Arrays.asList(1L, 2L, 3L);
        };

        Function<List<Long>, CompletableFuture<List<User>>> fetchUsers = ids -> {
            mySleep(250);
            Supplier<List<User>> userSupplier =
                    () -> {
                        System.out.println("Currently running in " + Thread.currentThread().getName());
                        return ids.stream().map(User::new).collect(Collectors.toList());
                    };
            return CompletableFuture.supplyAsync(userSupplier);
        };

        Function<List<Long>, CompletableFuture<List<Email>>> fetchEmails = ids -> {
            mySleep(350);
            Supplier<List<Email>> userSupplier =
                    () -> {
                        System.out.println("Currently running in " + Thread.currentThread().getName());
                        return ids.stream().map(Email::new).collect(Collectors.toList());
                    };
            return CompletableFuture.supplyAsync(userSupplier);
        };

        Consumer<List<User>> displayer = users -> {
            System.out.println("Display consumer in " + Thread.currentThread().getName());
            users.forEach(System.out::println);
        };

        CompletableFuture<List<Long>> completableFuture = CompletableFuture.supplyAsync(supplyIDs);

        CompletableFuture<List<User>> userFuture = completableFuture.thenCompose(fetchUsers);
        CompletableFuture<List<Email>> emailFuture = completableFuture.thenCompose(fetchEmails);

        userFuture.thenAcceptBoth(emailFuture, ((users, emails) -> {
            System.out.println("Users size: " + users.size() + " emails: " + emails.size());
        }));

        mySleep(1_000);
    }
}
