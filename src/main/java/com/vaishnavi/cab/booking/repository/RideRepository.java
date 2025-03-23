package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Ride;
import com.vaishnavi.cab.booking.connection.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class RideRepository implements EntityRepository<Ride>{

    @Override
    public void add(Ride ride) {
        String query = "INSERT INTO rides (ride_id, user_id, driver_id, pickup_location, dropoff_location, fare, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, ride.getRideId());
            statement.setInt(2, ride.getUserId());
            statement.setInt(3, ride.getDriverId());
            statement.setString(4, ride.getPickupLocation());
            statement.setString(5, ride.getDropoffLocation());
            statement.setDouble(6, ride.getFare());
            statement.setString(7, ride.getStatus());

            statement.executeUpdate();
            System.out.println("Ride added successfully.");
        } catch (SQLException e) {
            System.err.println("Error adding ride: " + e.getMessage());
        }
    }

    @Override
    public List<Ride> getAll() {
        List<Ride> rides = new ArrayList<>();
        String query = "SELECT * FROM rides";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Ride ride = new Ride(
                        resultSet.getInt("ride_id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("driver_id"),
                        resultSet.getString("pickup_location"),
                        resultSet.getString("dropoff_location"),
                        resultSet.getDouble("fare"),
                        resultSet.getString("status")
                );
                rides.add(ride);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching rides: " + e.getMessage());
        }
        return rides;
    }

    @Override
    public void update(Ride ride) {
        String query = "UPDATE rides SET pickup_location=?, dropoff_location=?, fare=?, status=? WHERE ride_id=?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, ride.getPickupLocation());
            statement.setString(2, ride.getDropoffLocation());
            statement.setDouble(3, ride.getFare());
            statement.setString(4, ride.getStatus());
            statement.setInt(5, ride.getRideId());

            statement.executeUpdate();
            System.out.println("Ride updated successfully.");
        } catch (SQLException e) {
            System.err.println("Error updating ride: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM rides WHERE ride_id=?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);

            statement.executeUpdate();
            System.out.println("Ride deleted successfully.");
        } catch (SQLException e) {
            System.err.println("Error deleting ride: " + e.getMessage());
        }
    }

    public void saveRide(Ride ride) {
    }

    public List<Ride> findAllRides() {
        return List.of();
    }

    public Optional<Ride> findRideById(int rideId) {
        return Optional.empty();
    }

    public boolean deleteRideById(int rideId) {
        return false;
    }

    public boolean updateRide(Ride ride) {
        return false;
    }
}
