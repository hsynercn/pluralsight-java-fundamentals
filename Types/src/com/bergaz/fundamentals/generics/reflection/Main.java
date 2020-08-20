package com.bergaz.fundamentals.generics.reflection;

public class Main {
    public static void main(String[] args) {
        Injector injector = new Injector().with("Hello world");

        /**
         * We used T generic type declaration for newInstance method, thus we don't have to cast it
         * Still we get compile error for inconsistent calls
         */
        //Logger logger1 = injector.newInstance(String.class);//we get a compile error
        Logger logger = injector.newInstance(Logger.class);
        logger.log();
    }
}
