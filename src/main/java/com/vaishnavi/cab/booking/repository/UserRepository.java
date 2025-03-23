package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.connection.DatabaseConnection;
import com.vaishnavi.cab.booking.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements EntityRepository<User> {

    @Override
    public void add(User user) {
        String query = "INSERT INTO users (user_id, name, email, phone) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, user.getUserId());
            statement.setString(2, user.getName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPhone());

            statement.executeUpdate();
            System.out.println("User added successfully.");
        } catch (SQLException e) {
            System.err.println("Error adding user: " + e.getMessage());
        }
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("user_id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching users: " + e.getMessage());
        }
        return users;
    }

    @Override
    public void update(User user) {
        String query = "UPDATE users SET name=?, email=?, phone=? WHERE user_id=?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPhone());
            statement.setInt(4, user.getUserId());

            statement.executeUpdate();
            System.out.println("User updated successfully.");
        } catch (SQLException e) {
            System.err.println("Error updating user: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM users WHERE user_id=?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);

            statement.executeUpdate();
            System.out.println("User deleted successfully.");
        } catch (SQLException e) {
            System.err.println("Error deleting user: " + e.getMessage());
        }
    }
}
