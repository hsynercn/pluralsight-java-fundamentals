package com.bergaz.fundamentals.iteration_one.asynchronous.exceptioncompletionstage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<List<User>> cf2 =
                CompletableFuture.supplyAsync(() -> List.of(1L, 2L, 3L))
                        .thenApply(list -> {
                            return readUsers(list);
                        });

        /**
         * If we use join or get we get the thrown exceptions
         */
        //List<User> userFromJoin = cf2.join();
        //List<User> userFromGet = cf2.get();

        /**
         * We have other options to get exception information
         * exceptionally()
         * whenComplete()
         * handle()
         */

        /**
         * exceptionally: Swallows the exception and returns a empty list
         */

        CompletableFuture<List<User>> cf3 = CompletableFuture.supplyAsync(() -> List.of(1L, 2L, 3L))
                .thenApply(list -> readUsers(list))
                .exceptionally(exception -> List.of());

        cf3.thenRun(() -> System.out.println("Then Run works OK"));

        /**
         * whenComplete: Does not swallow exception, in good case returns the same result, have async version
         */

        CompletableFuture<List<User>> cf4 = CompletableFuture.supplyAsync(() -> List.of(1L, 2L, 3L))
                .thenApply(list -> readUsers(list))
                .whenComplete(
                        (list, exception) -> {
                            if (list != null)
                                System.out.println("The list of users has been read");
                            else {
                                System.out.println("An exception has been raised");
                                System.out.println("Exception: " + exception.toString());
                            }
                        }
                );

        /**
         * handle: The bifunction can either process and swallow the exception, or rethrow it as needed,
         * have async version
         */

        CompletableFuture<List<User>> cf5 = CompletableFuture.supplyAsync(() -> List.of(1L, 2L, 3L))
                .thenApply(list -> readUsers(list))
                .handle(
                        (list, exception) -> {
                            if (list != null) {
                                return list;
                            } else {
                                System.out.println("An exception has been raised");
                                System.out.println("Exception: " + exception);
                                return new ArrayList<>();
                            }
                        }
                );
    }

    private static List<User> readUsers(List<Long> list) {
        ArrayList<User> users = new ArrayList<>();
        for (long temp : list) {
            users.add(new User(temp));
        }
        int exceptions = 8 / 0;
        return users;
    }
}
