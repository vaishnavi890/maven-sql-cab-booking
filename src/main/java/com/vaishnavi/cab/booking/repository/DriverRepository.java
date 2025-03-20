package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.connection.DatabaseConnection;
import com.vaishnavi.cab.booking.model.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriverRepository implements EntityRepository<Driver> {

    @Override
    public void add(Driver driver) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO drivers (driver_id, name, email, phone, cab_details) VALUES (?, ?, ?, ?, ?)")) {
            statement.setInt(1, driver.getDriverId());
            statement.setString(2, driver.getName());
            statement.setString(3, driver.getEmail());
            statement.setString(4, driver.getPhone());
            statement.setString(5, driver.getCabDetails());
            statement.executeUpdate();
            System.out.println("Driver added successfully.");
        } catch (SQLException e) {
            System.err.println("Error adding driver: " + e.getMessage());
        }
    }

    @Override
    public List<Driver> getAll() {
        List<Driver> driversList = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM drivers")) {

            while (resultSet.next()) {
                Driver driver = new Driver(
                        resultSet.getInt("driver_id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getString("cab_details")
                );
                driversList.add(driver);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching drivers: " + e.getMessage());
        }
        return driversList;
    }

    @Override
    public void update(Driver driver) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE drivers SET name=?, email=?, phone=?, cab_details=? WHERE driver_id=?")) {
            statement.setString(1, driver.getName());
            statement.setString(2, driver.getEmail());
            statement.setString(3, driver.getPhone());
            statement.setString(4, driver.getCabDetails());
            statement.setInt(5, driver.getDriverId());
            statement.executeUpdate();
            System.out.println("Driver updated successfully.");
        } catch (SQLException e) {
            System.err.println("Error updating driver: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM drivers WHERE driver_id=?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Driver deleted successfully.");
        } catch (SQLException e) {
            System.err.println("Error deleting driver: " + e.getMessage());
        }
    }
}
