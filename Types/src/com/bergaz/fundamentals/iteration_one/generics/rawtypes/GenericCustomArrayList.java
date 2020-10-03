package com.bergaz.fundamentals.iteration_one.generics.rawtypes;

import java.util.AbstractList;

public class GenericCustomArrayList<T> extends AbstractList<T>
{
    private T[] values;
    public GenericCustomArrayList() {
        /**
         * We can't use new T[], T is meaningless in runtime
         */
        //values = new T[0];

        /**
         * One way too declare a T type array, initialize with an Object array and cast to T[]
         */
        values = (T[]) new Object[0];

        /**
         * Another way we can still use a Object array use casting for required methods
         */
    }

    public T get(int index)
    {
        return values[index];
    }

    public boolean add(T o)
    {
        T[] newValues = (T[]) new Object[size() + 1];
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
