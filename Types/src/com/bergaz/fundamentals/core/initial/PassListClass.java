package com.bergaz.fundamentals.core.initial;

public class PassListClass {
    //SAME METHOD
    /*public void printStrList(Flight[] list) {
        for(Flight flight : list) {
            System.out.println("Flight: " + flight.getFlightNumber());
        }
    }*/
    public void printStrList(Flight... list) {
        for(Flight flight : list) {
            System.out.println("Flight: " + flight.getFlightNumber());
        }
    }
}
