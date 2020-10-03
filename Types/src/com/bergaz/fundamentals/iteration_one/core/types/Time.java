package com.bergaz.fundamentals.iteration_one.core.types;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Time {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        compareInstant(instant);
    }
    public static void compareInstant(Instant otherInstant) {
        Instant now = Instant.now();
        if(otherInstant.compareTo(now) > 0) {
            System.out.println("It is in the future");
        } else if(otherInstant.compareTo(now) < 0) {
            System.out.println("It is in the past");
        } else {
            System.out.println("It is now");
        }

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = localDate.format(formatter);

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM-yyyy-dd");
        LocalDate localDate1 = LocalDate.parse("02-1994-10", formatter1);
    }
}
