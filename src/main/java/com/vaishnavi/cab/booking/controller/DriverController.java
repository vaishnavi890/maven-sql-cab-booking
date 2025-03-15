package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.service.DriverService;

import java.util.Scanner;

public class DriverController {
    private DriverService driverService = new DriverService();
    private Scanner scanner = new Scanner(System.in);

    public void addDriver() {
        System.out.println("Enter Driver ID: ");
        int driverId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Email: ");
        String email = scanner.nextLine();
        System.out.println("Enter Phone: ");
        String phone = scanner.nextLine();
        System.out.println("Enter Cab Details: ");
        String cabDetails = scanner.nextLine();

        Driver driver = new Driver(driverId, name, email, phone, cabDetails);
        driverService.registerDriver(driver);
    }

    public void displayAllDrivers() {
        System.out.println("All Registered Drivers:");
        driverService.getAllDrivers();
    }

    public void findDriverById() {
        System.out.println("Enter Driver ID to search: ");
        int driverId = scanner.nextInt();
        driverService.findDriverById(driverId);
    }

    public void deleteDriver() {
        System.out.println("Enter Driver ID to delete: ");
        int driverId = scanner.nextInt();
        driverService.deleteDriverById(driverId);
    }

    public void updateDriver() {
        System.out.println("Enter Driver ID to update: ");
        int driverId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter New Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter New Email: ");
        String email = scanner.nextLine();
        System.out.println("Enter New Phone: ");
        String phone = scanner.nextLine();
        System.out.println("Enter New Cab Details: ");
        String cabDetails = scanner.nextLine();

        Driver driver = new Driver(driverId, name, email, phone, cabDetails);
        driverService.updateDriver(driver);
    }
}
