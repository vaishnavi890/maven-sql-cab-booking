package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Rating;
import com.vaishnavi.cab.booking.repository.RatingRepository;

import java.util.List;
import java.util.Optional;

public class RatingService {
    private RatingRepository ratingRepository = new RatingRepository();

    public void addRating(Rating rating) {
        ratingRepository.saveRating(rating);
    }

    public void getAllRatings() {
        List<Rating> ratings = ratingRepository.findAllRatings();
        ratings.forEach(System.out::println);
    }

    public void findRatingById(int ratingId) {
        Optional<Rating> rating = ratingRepository.findRatingById(ratingId);
        rating.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Rating with ID " + ratingId + " not found!")
        );
    }

    public void deleteRatingById(int ratingId) {
        if (!ratingRepository.deleteRatingById(ratingId)) {
            System.out.println("Rating deletion failed!");
        }
    }

    public void updateRating(Rating rating) {
        if (!ratingRepository.updateRating(rating)) {
            System.out.println("Rating update failed!");
        }
    }

    public void registerRating(Rating ratingObj) {
    }
}


