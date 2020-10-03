package com.bergaz.fundamentals.iteration_one.core.initial;

public enum FlightCrewJob {
    FLIGHT_ATTENDANT("Flight Attendant"),
    COPILOT("First Officer"),
    PILOT("Captain");
    private String title;
    public String getTitle() {
        return title;
    }
    private FlightCrewJob(String title) {
        this.title = title;
    }
}
