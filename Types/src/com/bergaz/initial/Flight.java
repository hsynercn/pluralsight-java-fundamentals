package com.bergaz.initial;

import java.util.ArrayList;
import java.util.Iterator;

public class Flight implements Comparable<Flight>, Iterable<Passenger>{

    private int passengers, seats = 150;
    private int flightNumber;
    private char flightClass;
    private boolean[] isSeatAvailable = new boolean[seats];

    private ArrayList<Passenger> passengerList = new ArrayList<Passenger>();

    private static int allPassengers;

    {
        for(int i = 0; i < getSeats(); i++) {
            isSeatAvailable[i] = true;
        }
    }

    public void add1Passenger() {
        int debug = getSeats();
        if(this.passengers < getSeats()){
            this.passengers++;
            allPassengers++;
        }
    }

    public Flight() {

    }

    public void addPassenger(Passenger p) {
        this.passengerList.add(p);
    }

    public  Flight(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getPassengers() {
        return passengers;
    }

    public int getSeats() {
        return seats;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public char getFlightClass() {
        return flightClass;
    }

    public boolean[] getIsSeatAvailable() {
        return isSeatAvailable;
    }

    public static int getAllPassengers() {
        return allPassengers;
    }

    @Override
    public boolean equals(Object obj) {
        if(super.equals(obj)) {
            return true;
        }
        if(obj instanceof Flight) {
            Flight f = (Flight) obj;
            return f.getFlightNumber() == this.getFlightNumber() &&
                    f.getFlightClass() == this.getFlightClass();
        } else {
            return false;
        }

    }

    @Override
    public int compareTo(Flight o) {
        return 0;
    }

    @Override
    public Iterator<Passenger> iterator() {
        return this.passengerList.iterator();
    }
}
