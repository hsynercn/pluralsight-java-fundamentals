package com.bergaz.fundamentals.generics.advancedtopics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class LambdaExamples {
    public static void main(String[] args) {
        Person donDraper = new Person("Don Draper", 89);
        Person peggyDraper = new Person("Peggy Olson", 65);
        Person bertCooper = new Person("Bert Cooper", 100);

        Predicate<Person> isOld = person -> person.getAge() > 80;

        System.out.println("is donDraper old: "+ isOld.test(donDraper));
        System.out.println("is peggyDraper old: " + isOld.test(peggyDraper));

        List<Person> personList = new ArrayList<>();
        personList.add(donDraper);
        personList.add(peggyDraper);
        personList.add(bertCooper);

        Map<Integer, List<Person>> mapByAge = personList.stream().collect(Collectors.groupingBy(Person::getAge));

        //Map<Boolean, List<Person>> isOldAndYoung = personList.stream().collect(Collectors.partitioningBy(isOld));

        Map<Boolean, List<Person>> isOldAndYoung =
                personList.stream().collect(Collectors.partitioningBy(person -> person.getAge() > 80));

        /**
         * If you get a compile error you probably made a type declaration mistake
         */
        Map<Boolean, Long> isOldAndYoungCounts =
                personList.stream().collect(Collectors.partitioningBy(person -> person.getAge() > 80, counting()));


        System.out.println(mapByAge);
        System.out.println(isOldAndYoung);
        System.out.println(isOldAndYoungCounts);

    }
}
