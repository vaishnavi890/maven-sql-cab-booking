package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Rating;
import com.vaishnavi.cab.booking.connection.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class RatingRepository implements EntityRepository<Rating>{
    @Override
    public void add(Rating rating) {
        String query = "INSERT INTO ratings (rating_id, ride_id, user_id, driver_id, rating, review) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, rating.getRatingId());
            statement.setInt(2, rating.getRideId());
            statement.setInt(3, rating.getUserId());
            statement.setInt(4, rating.getDriverId());
            statement.setInt(5, rating.getRating());
            statement.setString(6, rating.getReview());

            statement.executeUpdate();
            System.out.println("Rating added successfully.");
        } catch (SQLException e) {
            System.err.println("Error adding rating: " + e.getMessage());
        }
    }

    @Override
    public List<Rating> getAll() {
        List<Rating> ratings = new ArrayList<>();
        String query = "SELECT * FROM ratings";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int ratingId = resultSet.getInt("rating_id");
                int rideId = resultSet.getInt("ride_id");
                int userId = resultSet.getInt("user_id");
                int driverId = resultSet.getInt("driver_id");
                int ratingValue = resultSet.getInt("rating");
                String review = resultSet.getString("review");

                Rating rating = new Rating(ratingId, rideId, userId, driverId, ratingValue, review);
                ratings.add(rating);
            }
            System.out.println("Ratings fetched successfully.");
        } catch (SQLException e) {
            System.err.println("Error fetching ratings: " + e.getMessage());
        }
        return ratings;
    }

    @Override
    public void update(Rating rating) {
        String query = "UPDATE ratings SET ride_id = ?, user_id = ?, driver_id = ?, rating = ?, review = ? WHERE rating_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, rating.getRideId());
            statement.setInt(2, rating.getUserId());
            statement.setInt(3, rating.getDriverId());
            statement.setInt(4, rating.getRating());
            statement.setString(5, rating.getReview());
            statement.setInt(6, rating.getRatingId());

            int rowsUpdated = statement.executeUpdate();
            System.out.println(rowsUpdated > 0 ? "Rating updated successfully." : "No rating found with the given ID.");
        } catch (SQLException e) {
            System.err.println("Error updating rating: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM ratings WHERE rating_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            System.out.println(rowsDeleted > 0 ? "Rating deleted successfully." : "No rating found with the given ID.");
        } catch (SQLException e) {
            System.err.println("Error deleting rating: " + e.getMessage());
        }
    }

    public void saveRating(Rating rating) {
    }

    public List<Rating> findAllRatings() {
        return List.of();
    }

    public Optional<Rating> findRatingById(int ratingId) {
        return Optional.empty();
    }

    public boolean deleteRatingById(int ratingId) {
        return false;
    }

    public boolean updateRating(Rating rating) {
        return false;
    }
}

