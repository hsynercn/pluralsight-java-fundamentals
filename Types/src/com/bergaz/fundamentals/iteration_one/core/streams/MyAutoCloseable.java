package com.bergaz.fundamentals.iteration_one.core.streams;

import java.io.IOException;

public class MyAutoCloseable implements AutoCloseable{

    public void saySomething() throws IOException {
        System.out.println("Something");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Close");
    }
}
