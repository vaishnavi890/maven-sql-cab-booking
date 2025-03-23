package com.vaishnavi.cab.booking;

import com.vaishnavi.cab.booking.model.*;
import com.vaishnavi.cab.booking.controller.*;
import com.vaishnavi.cab.booking.repository.*;

import java.util.Scanner;
import java.util.List;

public class CabBooking {
    private static final UserRepository userRepository = new UserRepository();
    private static final DriverRepository driverRepository = new DriverRepository();
    private static final RideRepository rideRepository = new RideRepository();
    private static final PaymentRepository paymentRepository = new PaymentRepository();
    private static final RatingRepository ratingRepository = new RatingRepository();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Cab Order Management System ===");
            System.out.println("1. User Operations");
            System.out.println("2. Driver Operations");
            System.out.println("3. Ride Operations");
            System.out.println("4. Payment Operations");
            System.out.println("5. Rating Operations");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> userOperations();
                case 2 -> driverOperations();
                case 3 -> rideOperations();
                case 4 -> paymentOperations();
                case 5 -> ratingOperations();
                case 6 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
        scanner.close();
    }

    // User Operations
    private static void userOperations() {
        System.out.println("\n--- User Operations ---");
        System.out.println("1. Add User");
        System.out.println("2. View All Users");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter User ID: ");
                int userId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Email: ");
                String email = scanner.nextLine();
                System.out.print("Enter Phone: ");
                String phone = scanner.nextLine();
                User user = new User(userId, name, email, phone);
                userRepository.add(user);
            }
            case 2 -> {
                List<User> users = userRepository.getAll();
                users.forEach(System.out::println);
            }
            default -> System.out.println("Invalid choice.");
        }
    }

    // Driver Operations
    private static void driverOperations() {
        System.out.println("\n--- Driver Operations ---");
        System.out.println("1. Add Driver");
        System.out.println("2. View All Drivers");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter Driver ID: ");
                int driverId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Email: ");
                String email = scanner.nextLine();
                System.out.print("Enter Phone: ");
                String phone = scanner.nextLine();
                System.out.print("Enter Cab Details: ");
                String cabDetails = scanner.nextLine();
                Driver driver = new Driver(driverId, name, email, phone, cabDetails);
                driverRepository.add(driver);
            }
            case 2 -> {
                List<Driver> drivers = driverRepository.getAll();
                drivers.forEach(System.out::println);
            }
            default -> System.out.println("Invalid choice.");
        }
    }

    // Ride Operations
    private static void rideOperations() {
        System.out.println("\n--- Ride Operations ---");
        System.out.println("1. Add Ride");
        System.out.println("2. View All Rides");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter Ride ID: ");
                int rideId = scanner.nextInt();
                System.out.print("Enter User ID: ");
                int userId = scanner.nextInt();
                System.out.print("Enter Driver ID: ");
                int driverId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Pickup Location: ");
                String pickup = scanner.nextLine();
                System.out.print("Enter Dropoff Location: ");
                String dropoff = scanner.nextLine();
                System.out.print("Enter Fare: ");
                double fare = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Enter Status: ");
                String status = scanner.nextLine();
                Ride ride = new Ride(rideId, userId, driverId, pickup, dropoff, fare, status);
                rideRepository.add(ride);
            }
            case 2 -> {
                List<Ride> rides = rideRepository.getAll();
                rides.forEach(System.out::println);
            }
            default -> System.out.println("Invalid choice.");
        }
    }

    // Payment Operations
    private static void paymentOperations() {
        System.out.println("\n--- Payment Operations ---");
        System.out.println("1. Add Payment");
        System.out.println("2. View All Payments");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter Payment ID: ");
                int paymentId = scanner.nextInt();
                System.out.print("Enter Ride ID: ");
                int rideId = scanner.nextInt();
                System.out.print("Enter User ID: ");
                int userId = scanner.nextInt();
                System.out.print("Enter Amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Enter Payment Method: ");
                String method = scanner.nextLine();
                System.out.print("Enter Status: ");
                String status = scanner.nextLine();
                Payment payment = new Payment(paymentId, rideId, userId, amount, method, status);
                paymentRepository.add(payment);
            }
            case 2 -> {
                List<Payment> payments = paymentRepository.getAll();
                payments.forEach(System.out::println);
            }
            default -> System.out.println("Invalid choice.");
        }
    }

    // Rating Operations
    private static void ratingOperations() {
        System.out.println("\n--- Rating Operations ---");
        System.out.println("1. Add Rating");
        System.out.println("2. View All Ratings");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter Rating ID: ");
                int ratingId = scanner.nextInt();
                System.out.print("Enter Ride ID: ");
                int rideId = scanner.nextInt();
                System.out.print("Enter User ID: ");
                int userId = scanner.nextInt();
                System.out.print("Enter Driver ID: ");
                int driverId = scanner.nextInt();
                System.out.print("Enter Rating (1-5): ");
                int rating = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Review: ");
                String review = scanner.nextLine();
                Rating ratingObj = new Rating(ratingId, rideId, userId, driverId, rating, review);
                ratingRepository.add(ratingObj);
            }
            case 2 -> {
                List<Rating> ratings = ratingRepository.getAll();
                ratings.forEach(System.out::println);
            }
            default -> System.out.println("Invalid choice.");
        }
    }
}

