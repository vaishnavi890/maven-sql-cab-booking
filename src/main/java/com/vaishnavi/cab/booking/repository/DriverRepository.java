package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;


public class DriverRepository {
    private List<Driver> drivers = new ArrayList<>();

    // Save a new driver
    public void saveDriver(Driver driver) {
        drivers.add(driver);
        System.out.println("Driver saved successfully: " + driver);
    }

    // Get all drivers
    public List<Driver> findAllDrivers() {
        return new ArrayList<>(drivers);
    }

    // Find driver by ID using Stream and Optional
    public Optional<Driver> findDriverById(int driverId) {
        return drivers.stream()
                .filter(driver -> driver.getDriverId() == driverId)
                .findFirst();
    }

    // Remove driver by ID using Stream and Predicate
    public boolean deleteDriverById(int driverId) {
        Predicate<Driver> predicate = driver -> driver.getDriverId() == driverId;
        boolean removed = drivers.removeIf(predicate);
        if (removed) {
            System.out.println("Driver with ID " + driverId + " removed successfully!");
        } else {
            System.out.println("Driver with ID " + driverId + " not found!");
        }
        return removed;
    }

    // Update driver details
    public boolean updateDriver(Driver updatedDriver) {
        Optional<Driver> existingDriver = findDriverById(updatedDriver.getDriverId());
        existingDriver.ifPresent(driver -> {
            driver.setName(updatedDriver.getName());
            driver.setEmail(updatedDriver.getEmail());
            driver.setPhone(updatedDriver.getPhone());
            driver.setCabDetails(updatedDriver.getCabDetails());
            System.out.println("Driver updated successfully: " + driver);
        });
        return existingDriver.isPresent();
    }
}
