package com.bergaz.intermediate.the_core_platform.section_09;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class AccessingFieldInformation {
    public static Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static void main(String[] args) {
        Class<?> aClass = BankAccount.class;
        printFieldsInformation(aClass);
    }

    public static void printFieldsInformation(Class<?> aClass) {
        Field[] fields = aClass.getFields();
        System.out.println("Public declared and inherited members:");
        printFieldList(fields);
        System.out.println("Public, protected & private declared members:");
        Field[] declaredFields = aClass.getDeclaredFields();
        printFieldList(declaredFields);
    }

    public static void printFieldList(Field[] fields) {
        Arrays.asList(fields).forEach(field -> System.out.println(field.getName() + " : " + field.getType()));
    }
}
