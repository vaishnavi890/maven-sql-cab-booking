package com.vaishnavi.cab.booking.controller;


import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.service.DriverService;

import java.util.Scanner;

public class DriverController {
    private final DriverService driverService = new DriverService();

    public void manageDrivers() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nDriver Management");
            System.out.println("1. Add Driver");
            System.out.println("2. View All Drivers");
            System.out.println("3. Update Driver");
            System.out.println("4. Delete Driver");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Driver ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter Cab Details: ");
                    String cabDetails = scanner.nextLine();
                    driverService.addDriver(new Driver(id, name, email, phone, cabDetails));
                }
                case 2 -> driverService.getAllDrivers().forEach(System.out::println);
                case 3 -> {
                    System.out.print("Enter Driver ID to update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter New Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter New Phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter New Cab Details: ");
                    String cabDetails = scanner.nextLine();
                    driverService.updateDriver(new Driver(id, name, email, phone, cabDetails));
                }
                case 4 -> {
                    System.out.print("Enter Driver ID to delete: ");
                    int id = scanner.nextInt();
                    driverService.deleteDriver(id);
                }
                case 5 -> System.out.println("Exiting Driver Management...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    public void addDriver() {
    }

    public void displayAllDrivers() {
    }

    public void findDriverById() {
    }

    public void updateDriver() {
    }

    public void deleteDriver() {
    }
}
