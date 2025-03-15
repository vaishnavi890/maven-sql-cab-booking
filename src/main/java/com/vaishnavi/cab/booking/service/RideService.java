package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Ride;
import com.vaishnavi.cab.booking.repository.RideRepository;

import java.util.List;
import java.util.Optional;


public class RideService {
    private RideRepository rideRepository = new RideRepository();

    public void registerRide(Ride ride) {
        rideRepository.saveRide(ride);
    }

    public void getAllRides() {
        List<Ride> rides = rideRepository.findAllRides();
        rides.forEach(System.out::println);
    }

    public void findRideById(int rideId) {
        Optional<Ride> ride = rideRepository.findRideById(rideId);
        ride.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Ride with ID " + rideId + " not found!")
        );
    }

    public void deleteRideById(int rideId) {
        if (!rideRepository.deleteRideById(rideId)) {
            System.out.println("Ride deletion failed!");
        }
    }

    public void updateRide(Ride ride) {
        if (!rideRepository.updateRide(ride)) {
            System.out.println("Ride update failed!");
        }
    }
}
