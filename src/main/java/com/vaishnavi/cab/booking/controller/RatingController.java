package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Rating;
import com.vaishnavi.cab.booking.service.RatingService;

import java.util.List;
import java.util.Scanner;

public class RatingController {
    private final RatingService ratingService;
    private final Scanner scanner;

    public RatingController() {
        this.ratingService = new RatingService();
        this.scanner = new Scanner(System.in);
    }

    public void addRating() {
        System.out.println("Enter Ride ID:");
        int rideId = scanner.nextInt();
        System.out.println("Enter User ID:");
        int userId = scanner.nextInt();
        System.out.println("Enter Driver ID:");
        int driverId = scanner.nextInt();
        System.out.println("Enter Rating (1-5):");
        int ratingValue = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter Review:");
        String review = scanner.nextLine();

        Rating rating = new Rating(0, rideId, userId, driverId, ratingValue, review);
        ratingService.addRating(rating);
    }

    public void getAllRatings() {
        List<Rating> ratings = ratingService.getAllRatings();
        ratings.forEach(System.out::println);
    }

    public void updateRating() {
        System.out.println("Enter Rating ID to Update:");
        int ratingId = scanner.nextInt();
        System.out.println("Enter New Ride ID:");
        int rideId = scanner.nextInt();
        System.out.println("Enter New User ID:");
        int userId = scanner.nextInt();
        System.out.println("Enter New Driver ID:");
        int driverId = scanner.nextInt();
        System.out.println("Enter New Rating (1-5):");
        int ratingValue = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter New Review:");
        String review = scanner.nextLine();

        Rating rating = new Rating(ratingId, rideId, userId, driverId, ratingValue, review);
        ratingService.updateRating(rating);
    }

    public void deleteRating() {
        System.out.println("Enter Rating ID to Delete:");
        int ratingId = scanner.nextInt();
        ratingService.deleteRating(ratingId);
    }
}

