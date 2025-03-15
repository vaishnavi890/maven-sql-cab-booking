package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Ride;
import com.vaishnavi.cab.booking.service.RideService;

import java.util.Scanner;

public class RideController {
    private RideService rideService = new RideService();
    private Scanner scanner = new Scanner(System.in);

    public void addRide() {
        System.out.println("Enter Ride ID: ");
        int rideId = scanner.nextInt();
        System.out.println("Enter User ID: ");
        int userId = scanner.nextInt();
        System.out.println("Enter Driver ID: ");
        int driverId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Pickup Location: ");
        String pickupLocation = scanner.nextLine();
        System.out.println("Enter Dropoff Location: ");
        String dropoffLocation = scanner.nextLine();
        System.out.println("Enter Fare: ");
        double fare = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter Ride Status: ");
        String status = scanner.nextLine();

        Ride ride = new Ride(rideId, userId, driverId, pickupLocation, dropoffLocation, fare, status);
        rideService.registerRide(ride);
    }

    public void displayAllRides() {
        System.out.println("All Registered Rides:");
        rideService.getAllRides();
    }

    public void findRideById() {
        System.out.println("Enter Ride ID to search: ");
        int rideId = scanner.nextInt();
        rideService.findRideById(rideId);
    }

    public void deleteRide() {
        System.out.println("Enter Ride ID to delete: ");
        int rideId = scanner.nextInt();
        rideService.deleteRideById(rideId);
    }

    public void updateRide() {
        System.out.println("Enter Ride ID to update: ");
        int rideId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter New Pickup Location: ");
        String pickupLocation = scanner.nextLine();
        System.out.println("Enter New Dropoff Location: ");
        String dropoffLocation = scanner.nextLine();
        System.out.println("Enter New Fare: ");
        double fare = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter New Ride Status: ");
        String status = scanner.nextLine();

        Ride ride = new Ride(rideId, 0, 0, pickupLocation, dropoffLocation, fare, status);
        rideService.updateRide(ride);
    }
}
