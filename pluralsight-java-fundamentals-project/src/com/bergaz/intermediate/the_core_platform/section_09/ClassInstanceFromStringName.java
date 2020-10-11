package com.bergaz.intermediate.the_core_platform.section_09;

public class ClassInstanceFromStringName {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.bergaz.intermediate.the_core_platform.section_09.BankAccount");
            System.out.println(aClass.getSimpleName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
