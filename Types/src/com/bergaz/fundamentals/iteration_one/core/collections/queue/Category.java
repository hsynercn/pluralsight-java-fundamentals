package com.bergaz.fundamentals.iteration_one.core.collections.queue;

public enum Category {
    PRINTER("This is "),
    COMPUTER("a "),
    PHONE("funny "),
    TABLET(" thing.");

    final private String title;

    public String getTitle() {
        return title;
    }

    Category(String title) {
        this.title = title;
    }
}
