package com.bergaz.fundamentals.generics.advancedtopics.typeintersection;

import java.io.*;

public class IntersectionTypesCast
{
    public static void main(String[] args) throws Exception
    {
        /**
         * We are creating a serializable runnable, by this way we can write it to a file
         */
        Runnable helloWorld = (Serializable & Runnable) () ->
        {
            System.out.println("Hello World");
        };
        helloWorld.run();

        File file = File.createTempFile("runnable", "tmp");
        file.deleteOnExit();
        writeToFile(file, helloWorld);

        final Runnable runnable = (Runnable) readFromFile(file);
        runnable.run();
    }

    private static void writeToFile(final File file, Object object) throws IOException
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file)))
        {
            oos.writeObject(object);
        }
    }

    private static Object readFromFile(final File file) throws Exception
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file)))
        {
            return ois.readObject();
        }
    }
}
