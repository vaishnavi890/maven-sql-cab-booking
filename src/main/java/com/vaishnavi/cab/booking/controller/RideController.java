package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Ride;
import com.vaishnavi.cab.booking.service.RideService;

import java.util.List;

public class RideController {
    private final RideService rideService = new RideService();

    public void addRide(Ride ride) {
        try {
            rideService.addRide(ride);
            System.out.println("Ride added successfully.");
        } catch (Exception e) {
            System.err.println("Error adding ride: " + e.getMessage());
        }
    }

    public void getAllRides() {
        try {
            List<Ride> rides = rideService.getAllRides();
            rides.forEach(System.out::println);
        } catch (Exception e) {
            System.err.println("Error fetching rides: " + e.getMessage());
        }
    }

    public void updateRide(Ride ride) {
        try {
            rideService.updateRide(ride);
            System.out.println("Ride updated successfully.");
        } catch (Exception e) {
            System.err.println("Error updating ride: " + e.getMessage());
        }
    }

    public void deleteRide(int rideId) {
        try {
            rideService.deleteRide(rideId);
            System.out.println("Ride deleted successfully.");
        } catch (Exception e) {
            System.err.println("Error deleting ride: " + e.getMessage());
        }
    }
}
