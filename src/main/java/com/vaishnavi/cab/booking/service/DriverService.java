package com.vaishnavi.cab.booking.service;


import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.repository.DriverRepository;

import java.util.List;
import java.util.stream.Collectors;

public class DriverService {
    private final DriverRepository driverRepository = new DriverRepository();

    public void addDriver(Driver driver) {
        driverRepository.add(driver);
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.getAll();
    }

    public List<Driver> searchDriversByName(String name) {
        return driverRepository.getAll().stream()
                .filter(driver -> driver.getName().equals(name))
                .collect(Collectors.toList());
    }

    public void updateDriver(Driver driver) {
        driverRepository.update(driver);
    }

    public void deleteDriver(int driverId) {
        driverRepository.delete(driverId);
    }
}

