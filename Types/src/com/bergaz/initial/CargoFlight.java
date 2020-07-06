package com.bergaz.initial;

public class CargoFlight extends Flight{
    private float maxCargoSpace = 1000.0f;
    private float usedCargoSpace;

    private int seats = 12;

    public void add1Package(float h, float w, float d) {
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
