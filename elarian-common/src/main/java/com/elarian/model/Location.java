package com.elarian.model;

public final class Location {
    public String label = "";
    public String address = "";
    public double latitude;
    public double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Location(double latitude, double longitude, String label, String address) {
        this(latitude, longitude);
        this.label = label;
        this.address = address;
    }

}
