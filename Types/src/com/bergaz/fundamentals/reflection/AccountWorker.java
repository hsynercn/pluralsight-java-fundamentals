package com.bergaz.reflection;

import com.bergaz.fundamentals.annotations.WorkHandler;

@WorkHandler(useThreadPool = false)
public class AccountWorker implements Runnable{
    BankAccount ba;
    HighVolumeAccount hva;

    public AccountWorker(BankAccount ba) {
        this.ba = ba;
    }

    public AccountWorker(HighVolumeAccount hva) {
        this.hva = hva;
    }

    public void doWork() {
        Thread t = new Thread(hva != null ? hva : this);
        t.start();
    }

    @Override
    public void run() {

    }
}
