package com.bergaz.fundamentals.iteration_one.core.annotations;

public class Main {
    public static void main(String[] args) {
        SomeClass someClass = new SomeClass(1,"hello");
        System.out.println("Override: " + someClass.toString());
        MyWorker myWorker = new MyWorker();
        myWorker.doSomeWork();
    }
}
