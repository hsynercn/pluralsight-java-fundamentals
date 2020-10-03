package com.bergaz.intermediate.the_core_platform.section_03;

import java.io.IOException;

public class MyAutoCloseable implements AutoCloseable{
    public void sayHello() throws IOException {
        throw new IOException("Exception from sayHello");
        //System.out.println("MyAutoCloseable: Hello!");
    }
    @Override
    public void close() throws Exception {
        throw new IOException("Exception from close");
        //System.out.println("MyAutoCloseable: CLOSED");
    }
}
