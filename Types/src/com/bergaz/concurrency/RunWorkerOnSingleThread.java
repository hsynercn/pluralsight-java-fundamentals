package com.bergaz.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunWorkerOnSingleThread {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        BankAccount account = new BankAccount(100);

        RunnableWorker worker = new RunnableWorker(account);
        es.submit(worker);
    }
}
