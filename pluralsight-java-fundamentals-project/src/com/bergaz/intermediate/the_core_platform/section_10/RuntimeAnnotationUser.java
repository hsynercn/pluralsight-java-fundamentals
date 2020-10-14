package com.bergaz.intermediate.the_core_platform.section_10;

public class RuntimeAnnotationUser {
    public static void main(String[] args) {
        AnnotationUser annotationUser = new AnnotationUser();
        WorkHandler workHandler = annotationUser.getClass().getAnnotation(WorkHandler.class);

        if (workHandler.useThreadPool()) {
            System.out.println("useThreadPool: TRUE");
        } else {
            System.out.println("useThreadPool: FALSE");
        }
    }
}
