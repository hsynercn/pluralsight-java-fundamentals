package com.bergaz.fundamentals.generics.wildcards;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public class PersonSaver
{
    private final RandomAccessFile file;

    public PersonSaver(final File file) throws FileNotFoundException
    {
        this.file = new RandomAccessFile(file, "rw");
    }

    public void save(Person person) throws IOException
    {
        //file.writeUTF(person.getClass().getName());
        //file.writeUTF(person.getName());
        //file.writeInt(person.getAge());
    }

    public void saveAll(final List<? extends Person> people) throws IOException
    {
        for (Person person : people)
        {
            save(person);
        }
    }

    /**
     * First method declaration which takes a list of Person can't accept list of Partner, this strongly typed method
     * can't use a subclass list for input. For a single parameter accepting method this is not a problem. We can pass
     * a partner for person parameter.
     * We can overcome this behaviour by using a ? extends Person type for parameter list.
     * @param people
     * @throws IOException
     */
    //public void saveAllPersonType(List<Person> people) throws IOException
    //public <T extends Person> void saveAllPersonType(List<T> people) throws IOException//same a below line
    public void saveAllPersonType(List<? extends Person> people) throws IOException
    {
        for (Person person : people)
        {
            save(person);
        }
    }

    public void savePersonType(Person person) throws IOException
    {
        save(person);
    }

    /**
     * A Person array accepting method can be called with an Employee or Partner array.
     * @param people
     * @throws IOException
     */
    public void saveAll(final Person[] people) throws IOException
    {
        for (Person person : people)
        {
            save(person);
        }
    }
}
