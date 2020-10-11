package com.bergaz.intermediate.the_core_platform.section_09;

import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.util.StringJoiner;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class TypeModifiers {
    public static Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static void main(String[] args) {
        Class<?> aClass = BankAccount.class;
        int modifier = aClass.getModifiers();
        StringJoiner stringJoiner = new StringJoiner("],\n[", "[", "]");
        stringJoiner.add("isPublic:" + Modifier.isPublic(modifier));
        stringJoiner.add("isPrivate:" + Modifier.isPrivate(modifier));
        stringJoiner.add("isProtected:" + Modifier.isProtected(modifier));
        stringJoiner.add("isStatic:" + Modifier.isStatic(modifier));
        stringJoiner.add("isFinal:" + Modifier.isFinal(modifier));
        stringJoiner.add("isVolatile:" + Modifier.isVolatile(modifier));
        stringJoiner.add("isTransient:" + Modifier.isTransient(modifier));
        stringJoiner.add("isNative:" + Modifier.isNative(modifier));
        stringJoiner.add("isInterface:" + Modifier.isInterface(modifier));
        stringJoiner.add("isAbstract:" + Modifier.isAbstract(modifier));
        stringJoiner.add("isStrict:" + Modifier.isStrict(modifier));

        String formatted = String.format("\nCanonicalName: %1$s \n" +
                "SimpleName: %2$s \n" +
                "Name: %3$s \n"+
                "Type Name: %4$s \n" +
                "Package Name: %5$s\n" +
                "Modifiers:%6$s",
                aClass.getCanonicalName(),
                aClass.getSimpleName(),
                aClass.getName(),
                aClass.getTypeName(),
                aClass.getPackageName(),
                stringJoiner.toString());
        logger.severe(formatted);

    }
}
