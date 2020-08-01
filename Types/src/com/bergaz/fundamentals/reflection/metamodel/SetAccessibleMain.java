package com.bergaz.fundamentals.reflection.metamodel;

import com.bergaz.fundamentals.reflection.metamodel.annotation.Column;
import com.bergaz.fundamentals.reflection.metamodel.annotation.PrimaryKey;
import com.bergaz.fundamentals.reflection.metamodel.model.Person;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SetAccessibleMain {
    public static void main(String[] args) throws NoSuchFieldException,
            NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Person o = new Person();
        Class<?> clss = o.getClass();
        Field field = clss.getDeclaredField("name");
        Method method = clss.getDeclaredMethod("setName", String.class);
        method.invoke(o, "Sarah");

        field.setAccessible(true);
        String value = (String) field.get(o);
        field.set(o, "Carl");

        System.out.println("Give access value -> " + value);
        System.out.println("Name: " + o.getName());

        Field[] fields = clss.getDeclaredFields();

        for(Field tmpField:fields) {
            if (tmpField.getAnnotation(PrimaryKey.class) != null) {

            }
            if (tmpField.getAnnotation(Column.class) != null) {

            }
        }

    }
}
