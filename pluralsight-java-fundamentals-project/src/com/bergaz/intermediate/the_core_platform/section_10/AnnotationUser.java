package com.bergaz.intermediate.the_core_platform.section_10;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@WorkHandler(useThreadPool = true)
public class AnnotationUser implements Runnable{

    @Override
    public void run() {

    }
}
