package com.bergaz.initial;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        InitialValueClass initialValueClass = new InitialValueClass();

        Flight flight1 = new Flight(11);
        Flight flight2 = new Flight(11);
        Flight flight3 = new Flight(11);
        Flight flight4 = new Flight(11);

        PassListClass passListClass = new PassListClass();
        passListClass.printStrList(flight1, flight2, flight3);

        CargoFlight cargoFlight = new CargoFlight(77);
        cargoFlight.add1Package(1.0f, 4.0f, 6.0f);
        cargoFlight.add1Passenger();

        Flight flight = new CargoFlight(88);
        int debug = flight.getSeats();
        flight.add1Passenger();

        int seats1 = flight1.getSeats();
        int seats2 = flight.getSeats();
        int seats3 = cargoFlight.getSeats();

        cargoFlight.add1Passenger();

        CargoFlight cargoFlight1 = new CargoFlight(55);
        Object o = cargoFlight1;
        if(o instanceof CargoFlight) {
            CargoFlight cargoFlight2 = (CargoFlight) o;
            cargoFlight2.getSeats();
        }

        FlightCrewJob flightCrewJob = FlightCrewJob.FLIGHT_ATTENDANT;

        Passenger[] passengers = {
                new Passenger("Luisa", 1, 180),
                new Passenger("Jack", 1, 90),
                new Passenger("Ashanti", 3, 730),
                new Passenger("Vedat",2, 150 )
        };
        Arrays.sort(passengers);

    }
}
