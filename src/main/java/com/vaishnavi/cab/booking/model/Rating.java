package com.vaishnavi.cab.booking.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Rating {
    private int ratingId;
    private int rideId;
    private int userId;
    private int driverId;
    private int rating;
    private String review;

    public Rating(int ratingId, int rideId, int userId, int driverId, int rating, String review) {
        this.ratingId = ratingId;
        this.rideId = rideId;
        this.userId = userId;
        this.driverId = driverId;
        this.rating = rating;
        this.review = review;
    }

    public int getRatingId() {
        return 0;
    }

    public int getRating() {
        return null;
    }

    public String getReview() {
        return null;
    }

    public void setRating(Object rating) {
    }

    public void setReview(java.lang.Object review) {
    }

    public int getRideId() {
        return 0;
    }

    public int getUserId() {
        return 0;
    }

    public int getDriverId() {
        return 0;
    }
}
