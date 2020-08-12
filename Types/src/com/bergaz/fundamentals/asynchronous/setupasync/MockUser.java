package com.bergaz.fundamentals.asynchronous.setupasync;

public class MockUser {
    private long id;

    public MockUser(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void printInfo() {
        System.out.println("User:" + id);
    }
}
