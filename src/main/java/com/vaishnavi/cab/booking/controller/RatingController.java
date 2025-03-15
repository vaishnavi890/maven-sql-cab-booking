package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Rating;
import com.vaishnavi.cab.booking.service.RatingService;

import java.util.Scanner;

public class RatingController {
    private RatingService ratingService = new RatingService();
    private Scanner scanner = new Scanner(System.in);

    public void addRating() {
        System.out.println("Enter Rating ID: ");
        int ratingId = scanner.nextInt();
        System.out.println("Enter Ride ID: ");
        int rideId = scanner.nextInt();
        System.out.println("Enter User ID: ");
        int userId = scanner.nextInt();
        System.out.println("Enter Driver ID: ");
        int driverId = scanner.nextInt();
        System.out.println("Enter Rating (1-5): ");
        int rating = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Review: ");
        String review = scanner.nextLine();

        Rating ratingObj = new Rating(ratingId, rideId, userId, driverId, rating, review);
        ratingService.registerRating(ratingObj);
    }

    public void displayAllRatings() {
        System.out.println("All Ratings:");
        ratingService.getAllRatings();
    }

    public void findRatingById() {
        System.out.println("Enter Rating ID to search: ");
        int ratingId = scanner.nextInt();
        ratingService.findRatingById(ratingId);
    }

    public void deleteRating() {
        System.out.println("Enter Rating ID to delete: ");
        int ratingId = scanner.nextInt();
        ratingService.deleteRatingById(ratingId);
    }

    public void updateRating() {
        System.out.println("Enter Rating ID to update: ");
        int ratingId = scanner.nextInt();
        System.out.println("Enter New Rating (1-5): ");
        int rating = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter New Review: ");
        String review = scanner.nextLine();

        Rating ratingObj = new Rating(ratingId, 0, 0, 0, rating, review);
        ratingService.updateRating(ratingObj);
    }
}

