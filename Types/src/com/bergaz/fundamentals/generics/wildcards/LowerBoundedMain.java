package com.bergaz.fundamentals.generics.wildcards;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LowerBoundedMain {
    public static void main(String[] args) throws IOException {

        PersonSaver saver = new PersonSaver(new File("mock_file"));

        Partner donDraper = new Partner("Don Draper", 89);
        Partner peggyDraper = new Partner("Peggy Olson", 65);
        Employee bertCooper = new Employee("Bert Cooper", 100);

        saver.save(donDraper);
        saver.save(peggyDraper);

        List<Person> personList = new ArrayList<>();


    }
}
