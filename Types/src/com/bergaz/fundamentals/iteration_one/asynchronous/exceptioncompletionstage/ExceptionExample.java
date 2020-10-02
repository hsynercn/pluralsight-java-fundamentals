package com.bergaz.fundamentals.iteration_one.asynchronous.exceptioncompletionstage;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ExceptionExample {
    public static void main(String[] args) {
        Supplier<List<Long>> supplyIDs = () -> {
            mySleep(200);
            int a = 0 / 0;
            return Arrays.asList(1L, 2L, 3L);
        };

        Function<List<Long>, List<User>> fetchUsers = ids -> {
            mySleep(300);
            return ids.stream().map(User::new).collect(Collectors.toList());
        };

        Consumer<List<User>> displayer = users -> users.forEach(System.out::println);

        CompletableFuture<List<Long>> supply = CompletableFuture.supplyAsync(supplyIDs);

        //CompletableFuture<List<Long>> exception = supply.exceptionally(e -> List.of());//exceptionally method

        /*CompletableFuture<List<Long>> exception =   //whenComplete method
                supply.whenComplete((ids, e) -> {
                    if (e != null) {
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }
                });
        */

        CompletableFuture<List<Long>> exception = //handle method
                supply.handle(
                        (ids, e) -> {
                            if (e != null) {
                                System.out.println(e.getMessage());
                                e.printStackTrace();
                                return List.of();
                            } else {
                                return ids;
                            }
                        });

        CompletableFuture<List<User>> fetch = exception.thenApply(fetchUsers);
        CompletableFuture<Void> display = fetch.thenAccept(displayer);

        mySleep(1_000);

        System.out.println("Supply : done=" + supply.isDone() + " exception=" + supply.isCompletedExceptionally());
        System.out.println("Fetch : done=" + fetch.isDone() + " exception=" + fetch.isCompletedExceptionally());
        System.out.println("Display : done=" + display.isDone() + " exception=" + display.isCompletedExceptionally());
    }

    public static void mySleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
