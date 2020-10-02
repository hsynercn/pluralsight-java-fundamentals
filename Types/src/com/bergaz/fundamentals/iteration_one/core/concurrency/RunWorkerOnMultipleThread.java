package com.bergaz.fundamentals.iteration_one.core.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunWorkerOnMultipleThread {
    public static void main(String[] args) {

        wrapperSafeExecution();

    }

    private static void accountSafeExecution() {
        ExecutorService es = Executors.newFixedThreadPool(50);
        BankAccount account = new BankAccount(0);
        for(int i = 0; i < 500; i++) {
            RunnableWorker worker = new RunnableWorkerAccountSync(account);
            es.submit(worker);
        }
        System.out.println("Total:" + account.getBalance());
    }

    private static void wrapperSafeExecution() {
        ExecutorService es = Executors.newFixedThreadPool(50);
        BankAccount account = new BankAccount(0);
        for(int i = 0; i < 500; i++) {
            RunnableWorker worker = new RunnableWorkerSelfSync(account);
            es.submit(worker);
        }
        System.out.println("Total:" + account.getBalance());
    }

    private static void notSafeExecution() {
        ExecutorService es = Executors.newFixedThreadPool(50);
        BankAccount account = new BankAccount(0);
        for(int i = 0; i < 500; i++) {
            RunnableWorker worker = new RunnableWorkerNotSync(account);
            es.submit(worker);
        }
        System.out.println("Total:" + account.getBalance());
    }
}
