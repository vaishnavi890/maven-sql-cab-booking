package com.vaishnavi.cab.booking.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString


public class Ride {
    private int rideId;
    private int userId;
    private int driverId;
    private String pickupLocation;
    private String dropoffLocation;
    private double fare;
    private String status;

    public Ride(int rideId, int userId, int driverId, String pickupLocation, String dropoffLocation, double fare, String status) {
        this.rideId = rideId;
        this.userId = userId;
        this.driverId = driverId;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        this.fare = fare;
        this.status = status;
    }

    public int getRideId() {
        return 0;
    }

    public String getPickupLocation() {
        return null;
    }

    public String getDropoffLocation() {
        return null;
    }

    public double getFare() {
        return null;
    }

    public String getStatus() {
        return null;
    }

    public void setPickupLocation(Object pickupLocation) {
    }

    public void setDropoffLocation(Object dropoffLocation) {
    }

    public void setFare(Object fare) {
    }

    public void setStatus(java.lang.Object status) {
    }

    public int getUserId() {
        return 0;
    }

    public int getDriverId() {
        return 0;
    }
}
