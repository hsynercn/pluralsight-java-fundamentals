package com.bergaz.initial;

import java.util.regex.PatternSyntaxException;

final public class Passenger implements Comparable<Passenger>{
    private String name;
    private int memberLevel; //3 (1st priority), 2, 1
    private int memberDays;

    public Passenger(String name, int memberLevel, int memberDays) {
        this.name = name;
        this.memberLevel = memberLevel;
        this.memberDays = memberDays;
    }

    public int compareTo(Passenger p) {
        int returnValue = p.memberLevel - memberLevel;
        if (returnValue == 0) {
            returnValue = p.memberDays - memberDays;
        }
        return returnValue;
    }
}
