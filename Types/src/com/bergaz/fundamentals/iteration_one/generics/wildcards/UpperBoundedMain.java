package com.bergaz.fundamentals.iteration_one.generics.wildcards;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * GENERICS IS ABOUT SAFETY WITHOUT CODE DUPLICATION
 */
public class UpperBoundedMain {
    public static void main(String[] args) throws IOException {
        File file;
        PersonSaver saver = new PersonSaver(new File("mock_file"));
        PersonLoader loader;

        Partner donDraper = new Partner("Don Draper", 89);
        Partner peggyDraper = new Partner("Peggy Olson", 65);
        Employee bertCooper = new Employee("Bert Cooper", 100);

        Person person = new Person("Bob", 20);
        saver.save(person);

        saver.savePersonType(donDraper);
        saver.save(peggyDraper);
        saver.save(bertCooper);

        Person personType = donDraper;


        List<Partner> partners = new ArrayList<>();
        partners.add(donDraper);
        partners.add(peggyDraper);
        saver.saveAllPersonType(partners);

        List<Person> persons = new ArrayList<>();
        persons.add(donDraper);
        persons.add(bertCooper);
        saver.saveAll(persons);

        /*
        This is safe usage
         */
        Partner[] partnerArray = new Partner[2];
        Person[] personArray = partnerArray;
        partnerArray[0] = donDraper;
        partnerArray[1] = peggyDraper;
        saver.saveAll(partnerArray);

        /*
        This is unsafe usage, we assigned an Employee to a Partner array
         */
        Partner[] partnerArray1 = new Partner[3];
        Person[] personArray1 = partnerArray1;
        personArray1[0] = donDraper;
        personArray1[1] = peggyDraper;
        //personArray1[2] = bertCooper;

        saver.saveAll(partnerArray);


    }
}
