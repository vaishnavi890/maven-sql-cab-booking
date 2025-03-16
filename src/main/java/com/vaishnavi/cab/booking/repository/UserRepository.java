package com.vaishnavi.cab.booking.repository;


import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class UserRepository {

    public void addUser(String name, String email, String phone) {
        String sql = "INSERT INTO users (name, email, phone) VALUES ('" + name + "', '" + email + "', '" + phone + "')";

        Connection Connection = null;
        try (Statement stmt = Connection.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            System.out.println(rowsAffected + " row(s) inserted.");
        } catch (SQLException e) {
            System.err.println("Error adding user: " + e.getMessage());
        }
    }

}