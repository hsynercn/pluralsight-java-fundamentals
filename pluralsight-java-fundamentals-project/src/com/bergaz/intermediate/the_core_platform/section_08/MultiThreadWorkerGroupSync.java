package com.bergaz.intermediate.the_core_platform.section_08;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreadWorkerGroupSync {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        SyncBankAccount syncBankAccount = new SyncBankAccount(100);

        for (int i = 0; i < 1000; i++) {
            executorService.submit(new Worker(syncBankAccount));
        }

        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS);
        System.out.println("FINAL RESULT: " + syncBankAccount.getBalance());
    }
}
