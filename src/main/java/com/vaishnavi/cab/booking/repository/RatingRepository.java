package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Rating;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;


public class RatingRepository {
    private List<Rating> ratings = new ArrayList<>();

    // Save a new rating
    public void saveRating(Rating rating) {
        ratings.add(rating);
        System.out.println("Rating saved successfully: " + rating);
    }

    // Get all ratings
    public List<Rating> findAllRatings() {
        return new ArrayList<>(ratings);
    }

    // Find rating by ID
    public Optional<Rating> findRatingById(int ratingId) {
        return ratings.stream()
                .filter(rating -> rating.getRatingId() == ratingId)
                .findFirst();
    }

    // Remove rating by ID
    public boolean deleteRatingById(int ratingId) {
        Predicate<Rating> predicate = rating -> rating.getRatingId() == ratingId;
        boolean removed = ratings.removeIf(predicate);
        if (removed) {
            System.out.println("Rating with ID " + ratingId + " removed successfully!");
        } else {
            System.out.println("Rating with ID " + ratingId + " not found!");
        }
        return removed;
    }

    // Update rating details
    public boolean updateRating(Rating updatedRating) {
        Optional<Rating> existingRating = findRatingById(updatedRating.getRatingId());
        existingRating.ifPresent(rating -> {
            rating.setRating(updatedRating.getRating());
            rating.setReview(updatedRating.getReview());
            System.out.println("Rating updated successfully: " + rating);
        });
        return existingRating.isPresent();
    }
}

