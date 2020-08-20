package com.bergaz.fundamentals.generics.wildcards;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class PersonLoader
{
    private final RandomAccessFile file;

    public PersonLoader(final File file) throws FileNotFoundException
    {
        this.file = new RandomAccessFile(file, "rw");
    }

    public Person load() throws ClassNotFoundException
    {
        /**
         * This is the unbounded wildcard example
         */
        try
        {
            final String className = file.readUTF();
            final String personName = file.readUTF();
            final int age = file.readInt();

            /**
             * Class can be anything with question mark
             * Java Object class is completely different case, it is a strong type
             */
            //final Class<? extends Object> personClass = Class.forName(className);//Syntactic sugar
            final Class<?> personClass = Class.forName(className);
            final Constructor<?> constructor = personClass.getConstructor(String.class, int.class);
            return (Person) constructor.newInstance(personName, age);
        }
        catch (IOException e)
        {
            return null;
        }
        catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * We want to use Person or parent classes of Person class, for Person class we can use Object
     * @param people
     * @throws ClassNotFoundException
     */
    public void loadAll(final List<? super Person> people) throws ClassNotFoundException
    {
        Person person;

        while ((person = load()) != null)
        {
            people.add(person);
        }
    }
}
