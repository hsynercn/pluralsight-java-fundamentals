package com.bergaz.fundamentals.iteration_one.core.initial;

public class CargoFlight extends Flight{
    private float maxCargoSpace = 1000.0f;
    private float usedCargoSpace;

    private int seats = 12;

    public CargoFlight(int flightNumber) {
        super(flightNumber);
    }

    public CargoFlight(int flightNumber, float maxCargoSpace) {
        this(flightNumber);
        this.maxCargoSpace = maxCargoSpace;
    }



    /*
    * No one can override this method*/
    public final void add1Package(float h, float w, float d) {
        float volume = h * w * d;
        if(hasCargoSpace(volume)) {
            usedCargoSpace += volume;
        } else {
            handleNoSpace();
        }
    }

    private void handleNoSpace() {
        System.out.println("Not enough space");
    }

    private boolean hasCargoSpace(float volume) {
        return usedCargoSpace + volume <= maxCargoSpace;
    }

    public float getMaxCargoSpace() {
        return maxCargoSpace;
    }

    public float getUsedCargoSpace() {
        return usedCargoSpace;
    }

    @Override
    public int getSeats() {
        return seats;
    }
}
