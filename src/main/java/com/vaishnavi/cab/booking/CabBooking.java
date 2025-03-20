package com.vaishnavi.cab.booking;

import com.vaishnavi.cab.booking.model.User;
import com.vaishnavi.cab.booking.controller.*;
import com.vaishnavi.cab.booking.repository.UserRepository;

import java.util.Scanner;


public class CabBooking {
    public static void main(String[] args) {
        UserController userController = new UserController();
        DriverController driverController = new DriverController();
        RideController rideController = new RideController();
        PaymentController paymentController = new PaymentController();
        RatingController ratingController = new RatingController();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Cab Order Management System ===");
            System.out.println("1. User Management");
            System.out.println("2. Driver Management");
            System.out.println("3. Ride Management");
            System.out.println("4. Payment Management");
            System.out.println("5. Rating Management");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    userManagement(userController);
                    break;
                case 2:
                    driverManagement(driverController);
                    break;
                case 3:
                    rideManagement(rideController);
                    break;
                case 4:
                    paymentManagement(paymentController);
                    break;
                case 5:
                    ratingManagement(ratingController);
                    break;
                case 0:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void userManagement(UserController userController) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== User Management ===");
        System.out.println("1. Add User");
        System.out.println("2. View All Users");
        System.out.println("3. Find User by ID");
        System.out.println("4. Update User");
        System.out.println("5. Delete User");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> userController.addUser();
            case 2 -> userController.displayAllUsers();
            case 3 -> userController.findUserById();
            case 4 -> userController.updateUser();
            case 5 -> userController.deleteUser();
            default -> System.out.println("Invalid choice!");
        }
    }

    private static void driverManagement(DriverController driverController) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Driver Management ===");
        System.out.println("1. Add Driver");
        System.out.println("2. View All Drivers");
        System.out.println("3. Find Driver by ID");
        System.out.println("4. Update Driver");
        System.out.println("5. Delete Driver");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> driverController.addDriver();
            case 2 -> driverController.displayAllDrivers();
            case 3 -> driverController.findDriverById();
            case 4 -> driverController.updateDriver();
            case 5 -> driverController.deleteDriver();
            default -> System.out.println("Invalid choice!");
        }
    }

    private static void rideManagement(RideController rideController) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Ride Management ===");
        System.out.println("1. Add Ride");
        System.out.println("2. View All Rides");
        System.out.println("3. Find Ride by ID");
        System.out.println("4. Update Ride");
        System.out.println("5. Delete Ride");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> rideController.addRide();
            case 2 -> rideController.displayAllRides();
            case 3 -> rideController.findRideById();
            case 4 -> rideController.updateRide();
            case 5 -> rideController.deleteRide();
            default -> System.out.println("Invalid choice!");
        }
    }

    private static void paymentManagement(PaymentController paymentController) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Payment Management ===");
        System.out.println("1. Add Payment");
        System.out.println("2. View All Payments");
        System.out.println("3. Find Payment by ID");
        System.out.println("4. Update Payment");
        System.out.println("5. Delete Payment");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> paymentController.addPayment();
            case 2 -> paymentController.displayAllPayments();
            case 3 -> paymentController.findPaymentById();
            case 4 -> paymentController.updatePayment();
            case 5 -> paymentController.deletePayment();
            default -> System.out.println("Invalid choice!");
        }
    }

    private static void ratingManagement(RatingController ratingController) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Rating Management ===");
        System.out.println("1. Add Rating");
        System.out.println("2. View All Ratings");
        System.out.println("3. Find Rating by ID");
        System.out.println("4. Update Rating");
        System.out.println("5. Delete Rating");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> ratingController.addRating();
            case 2 -> ratingController.displayAllRatings();
            case 3 -> ratingController.findRatingById();
            case 4 -> ratingController.updateRating();
            case 5 -> ratingController.deleteRating();
            default -> System.out.println("Invalid choice!");
        }
    }
}

