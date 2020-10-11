package com.bergaz.intermediate.the_core_platform.section_09;

public class ClassInstanceFromTypeReference {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("1234");
        Class<?> aClass = bankAccount.getClass();
        System.out.println(aClass.getSimpleName());
    }
}
