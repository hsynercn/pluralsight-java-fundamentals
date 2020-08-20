package com.bergaz.fundamentals.generics.reflection;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReflectGenericInformation {
    public static class StringList extends ArrayList<String> {

    }
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        Class<?> arrayList = strings.getClass();
        System.out.println(arrayList);
        TypeVariable<? extends Class<?>>[] typeParameters = arrayList.getTypeParameters();
        System.out.println(Arrays.toString(typeParameters));
        System.out.println(arrayList.toGenericString());
        System.out.println(arrayList.toString());

        /**
         * We can extract the concrete init info
         */
        ParameterizedType arrayListOfString = (ParameterizedType) StringList.class.getGenericSuperclass();
        System.out.println("arrayListOfString:");
        System.out.println(Arrays.toString(arrayListOfString.getActualTypeArguments()));
    }
}
