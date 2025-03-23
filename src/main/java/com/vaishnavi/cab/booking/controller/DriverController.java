package com.vaishnavi.cab.booking.controller;


import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.service.DriverService;

import java.util.List;

public class DriverController {
    private final DriverService driverService = new DriverService();

    public void addDriver(Driver driver) {
        try {
            driverService.addDriver(driver);
            System.out.println("Driver added successfully.");
        } catch (Exception e) {
            System.err.println("Error adding driver: " + e.getMessage());
        }
    }

    public void getAllDrivers() {
        try {
            List<Driver> drivers = driverService.getAllDrivers();
            drivers.forEach(System.out::println);
        } catch (Exception e) {
            System.err.println("Error fetching drivers: " + e.getMessage());
        }
    }

    public void updateDriver(Driver driver) {
        try {
            driverService.updateDriver(driver);
            System.out.println("Driver updated successfully.");
        } catch (Exception e) {
            System.err.println("Error updating driver: " + e.getMessage());
        }
    }

    public void deleteDriver(int driverId) {
        try {
            driverService.deleteDriver(driverId);
            System.out.println("Driver deleted successfully.");
        } catch (Exception e) {
            System.err.println("Error deleting driver: " + e.getMessage());
        }
    }

    public void displayAllDrivers() {
    }
}
