package com.bergaz.fundamentals.asynchronous;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FirstCompletableFutures {
    public static void main(String[] args) throws InterruptedException {

        //runRunnable();
        runRunnableWithExecutor();

    }

    private static void runRunnableWithExecutor() throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Runnable task = () -> System.out.println("I am running asynchronously Thread: " + Thread.currentThread().getName());
        //This thread si from pool-1-thread-1
        CompletableFuture.runAsync(task, executor);
        /**
         *  With providing an ExecutorService to runAsync we can prevent main thread from exiting. But in this case we
         *  need to shutdown the executor manually, otherwise main thread can't exit. Shutdown executes all submitted
         *  tasks.
         */
        executor.shutdown();
    }

    private static void runRunnable() throws InterruptedException {
        Runnable task = () -> System.out.println("I am running asynchronously Thread: " + Thread.currentThread().getName());
        //this thread is from ForkJoinPool
        CompletableFuture.runAsync(task);
        /**
         *  Without sleep we can't see print, because upper task launched in common fork/joined pool. This fork/joined
         *  pool made of deamon threads. They do not prevent from JVM exiting, thus upper task can't get a change to
         *  print text.
         */
        Thread.sleep(100);
    }
}
