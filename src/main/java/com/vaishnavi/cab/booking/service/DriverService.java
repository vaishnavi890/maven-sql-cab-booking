package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.repository.DriverRepository;
import java.util.List;
import java.util.Optional;


public class DriverService {
    private DriverRepository driverRepository = new DriverRepository();

    public void registerDriver(Driver driver) {
        driverRepository.saveDriver(driver);
    }

    public void getAllDrivers() {
        List<Driver> drivers = driverRepository.findAllDrivers();
        drivers.forEach(System.out::println);
    }

    public void findDriverById(int driverId) {
        Optional<Driver> driver = driverRepository.findDriverById(driverId);
        driver.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Driver with ID " + driverId + " not found!")
        );
    }

    public void deleteDriverById(int driverId) {
        if (!driverRepository.deleteDriverById(driverId)) {
            System.out.println("Driver deletion failed!");
        }
    }

    public void updateDriver(Driver driver) {
        if (!driverRepository.updateDriver(driver)) {
            System.out.println("Driver update failed!");
        }
    }
}

