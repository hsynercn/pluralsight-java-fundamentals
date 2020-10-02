package com.bergaz.fundamentals.iteration_one.core.initial;

public class CargoOnlyPilot extends Pilot {

    @Override
    public boolean canAccept(Flight f) {
        return f.getPassengers() == 0;
    }
}
