package com.bergaz.fundamentals.core.initial;

final public class Passenger implements Comparable<Passenger>{
    private String name;

    public static class RewardProgram {
        private int memberLevel; //3 (1st priority), 2, 1
        private int memberDays;
    }

    private RewardProgram rewardProgram = new RewardProgram();

    public Passenger(String name, int memberLevel, int memberDays) {
        this.name = name;
        this.rewardProgram.memberLevel = memberLevel;
        this.rewardProgram.memberDays = memberDays;
    }

    public int compareTo(Passenger p) {
        int returnValue = p.rewardProgram.memberLevel - rewardProgram.memberLevel;
        if (returnValue == 0) {
            returnValue = p.rewardProgram.memberDays - rewardProgram.memberDays;
        }
        return returnValue;
    }

    public String getName() {
        return name;
    }
}
