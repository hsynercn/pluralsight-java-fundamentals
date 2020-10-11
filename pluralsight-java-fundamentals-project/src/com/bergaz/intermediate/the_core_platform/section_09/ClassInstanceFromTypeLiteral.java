package com.bergaz.intermediate.the_core_platform.section_09;

public class ClassInstanceFromTypeLiteral {
    public static void main(String[] args){
        Class<?> aClass = BankAccount.class;
        System.out.println(aClass.getSimpleName());
    }
}
