package com.bergaz.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SerializableGroup implements Serializable {
    private static final long serialVersionUID = -7088450105895796095L;
    private Map<String, SerializableClass> serializableClassMap = new HashMap<>();
    private transient int totalBalance;

    public int getTotalBalance() {
        return totalBalance;
    }

    public void addSerializable(SerializableClass serializableClass) {
        totalBalance += serializableClass.getBalance();
        serializableClassMap.put(serializableClass.getId(), serializableClass);
    }

    void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        for(SerializableClass serializableClass : serializableClassMap.values()) {
            totalBalance += serializableClass.getBalance();
        }
    }
}
