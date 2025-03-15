package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Ride;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class RideRepository {
    private List<Ride> rides = new ArrayList<>();

    // Save a new ride
    public void saveRide(Ride ride) {
        rides.add(ride);
        System.out.println("Ride saved successfully: " + ride);
    }

    // Get all rides
    public List<Ride> findAllRides() {
        return new ArrayList<>(rides);
    }

    // Find ride by ID
    public Optional<Ride> findRideById(int rideId) {
        return rides.stream()
                .filter(ride -> ride.getRideId() == rideId)
                .findFirst();
    }

    // Remove ride by ID
    public boolean deleteRideById(int rideId) {
        Predicate<Ride> predicate = ride -> ride.getRideId() == rideId;
        boolean removed = rides.removeIf(predicate);
        if (removed) {
            System.out.println("Ride with ID " + rideId + " removed successfully!");
        } else {
            System.out.println("Ride with ID " + rideId + " not found!");
        }
        return removed;
    }

    // Update ride details
    public boolean updateRide(Ride updatedRide) {
        Optional<Ride> existingRide = findRideById(updatedRide.getRideId());
        existingRide.ifPresent(ride -> {
            ride.setPickupLocation(updatedRide.getPickupLocation());
            ride.setDropoffLocation(updatedRide.getDropoffLocation());
            ride.setFare(updatedRide.getFare());
            ride.setStatus(updatedRide.getStatus());
            System.out.println("Ride updated successfully: " + ride);
        });
        return existingRide.isPresent();
    }
}
