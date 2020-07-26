package com.bergaz.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunWorkerOnMultipleThread {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(50);
        BankAccount account = new BankAccount(0);
        for(int i = 0; i < 500; i++) {
            RunnableWorker worker = new RunnableWorker(account);
            es.submit(worker);
        }
        System.out.println("Total:" + account.getBalance());
    }
}
