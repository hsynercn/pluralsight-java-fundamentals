package com.bergaz.fundamentals.iteration_one.generics.rawtypes;

/**
 * If we try to use T we get
 * Generic class may not extend 'java.lang.Throwable'
 * compile error
 */
public class UncompilableException/*<T>*/ extends Exception{
    public static void main(String[] args) {
        try {
            throw new UncompilableException();
        } catch (UncompilableException e) {
            e.printStackTrace();
        }
    }
}
