package com.bergaz.initial;

public class Flight {
    private int passengers, seats = 150;
    private int flightNumber;
    private char flightClass;
    private boolean[] isSeatAvailable = new boolean[seats];

    private static int allPassengers;

    {
        for(int i = 0; i < seats; i++) {
            isSeatAvailable[i] = true;
        }
    }

    public void add1Passenger() {
        if(this.passengers < seats){
            this.passengers++;
            allPassengers++;
        }
    }

    public  Flight(int flightNumber) {
        this.flightNumber = flightNumber;
    }
}
