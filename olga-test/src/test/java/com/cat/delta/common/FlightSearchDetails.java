package com.cat.delta.common;

public class FlightSearchDetails {
    String origin;
    String destination;
    String tripType;

    public FlightSearchDetails(String origin, String destination, String tripType) {
        this.origin = origin;
        this.destination = destination;
        this.tripType = tripType;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }
    public String getTripType() {
        return tripType;
    }
}
