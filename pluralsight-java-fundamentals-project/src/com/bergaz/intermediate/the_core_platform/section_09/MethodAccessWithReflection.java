package com.bergaz.intermediate.the_core_platform.section_09;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodAccessWithReflection {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("1234", 500);
        callGetId(bankAccount);
        callDeposit(bankAccount, 50);
        System.out.println("Balance: " + bankAccount.getBalance());
    }

    public static void callGetId(Object obj) {
        Class<?> aClass = obj.getClass();
        try {
            Method m = aClass.getMethod("getId");
            Object result = m.invoke(obj);
            System.out.println("Result: " + result);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void callDeposit(Object obj, int amt) {
        Class<?> aClass = obj.getClass();
        try {
            Method method = aClass.getMethod("deposit", int.class);
            method.invoke(obj, 50);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
