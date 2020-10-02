package com.bergaz.fundamentals.iteration_one.core.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        SerializableClass serializableClass = new SerializableClass("test", 1);
        serializableClass.deposit(200);

        String path = "C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\serialized.dot";
        saveObject(serializableClass, path);
        SerializableClass serializableClass1 = loadObject(path);
    }

    private static void saveObject(SerializableClass serializableClass, String fileName) {
        try(ObjectOutputStream objectStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)));) {
            objectStream.writeObject(serializableClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static SerializableClass loadObject(String fileName) {
        SerializableClass serializableClass = null;

        try(ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            serializableClass = (SerializableClass) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return serializableClass;
    }
}
