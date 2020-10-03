package com.bergaz.fundamentals.iteration_one.moreobjectoriented.optionalcallstocallsonoptionalobjects;

public class OptionalDemo {
    private void display(String value) {
        String print = value == null ? "Nothing" : value.toUpperCase();
        System.out.println(print);
    }

    public void run() {
        this.display(null);
        this.display("Something");
        this.display("Making Your Java Code More Object-oriented");
    }
}
