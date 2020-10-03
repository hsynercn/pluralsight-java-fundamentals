package com.bergaz.fundamentals.iteration_one.reflection.methodhandle;
import com.bergaz.fundamentals.iteration_one.reflection.metamodel.model.Person;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;

public class PlayWithMethodHandle {
    public static void main(String[] args) throws Throwable {

        Lookup lookup = MethodHandles.lookup();

        MethodType emptyConstructorMethodtype = MethodType.methodType(void.class);
        MethodHandle emptyConstructor = lookup.findConstructor(Person.class, emptyConstructorMethodtype);

        Person p = (Person) emptyConstructor.invoke();
        System.out.println(p);

        MethodType constructorMethodtype = MethodType.methodType(void.class, String.class, int.class);
        MethodHandle constructor = lookup.findConstructor(Person.class, constructorMethodtype);

        Person p2 = (Person) constructor.invoke("James", 20);
        System.out.println(p2);

        MethodType nameGetterMethodType = MethodType.methodType(String.class);
        MethodHandle nameGetter = lookup.findVirtual(Person.class, "getName", nameGetterMethodType);

        String name = (String) nameGetter.invoke(p2);
        System.out.println("NAME: " + name);



    }
}
