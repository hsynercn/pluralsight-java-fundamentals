package com.bergaz.intermediate.the_core_platform.section_08;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreadWorkerGroup {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        BankAccount bankAccount = new BankAccount(100);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new Worker(bankAccount));
        }

        /**
         * After several tries we can see result becomes a different value than 100100
         */

        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS);
        System.out.println("FINAL RESULT: " + bankAccount.getBalance());
    }
}
