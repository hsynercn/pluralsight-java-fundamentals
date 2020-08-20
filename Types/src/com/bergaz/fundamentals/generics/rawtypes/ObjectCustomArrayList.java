package com.bergaz.fundamentals.generics.rawtypes;

import java.util.AbstractList;
import java.util.List;

public class ObjectCustomArrayList extends AbstractList
{
    private Object[] values;
    public ObjectCustomArrayList() {
        values = new Object[0];
    }

    public Object get(int index)
    {
        return values[index];
    }

    public boolean add(Object o)
    {
        Object[] newValues = new Object[size() + 1];
        for (int i = 0; i < size(); i++) {
            newValues[i] = values[i];
        }
        newValues[size()] = o;
        values = newValues;
        return true;
    }

    public int size()
    {
        return values.length;
    }

}
