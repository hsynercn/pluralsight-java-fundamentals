package com.bergaz.fundamentals.core.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunWorkerOnSingleThread {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        BankAccount account = new BankAccount(100);

        RunnableWorker worker = new RunnableWorkerNotSync(account);
        es.submit(worker);
    }
}
