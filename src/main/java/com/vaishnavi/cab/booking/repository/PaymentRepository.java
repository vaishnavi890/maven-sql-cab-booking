package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Payment;
import com.vaishnavi.cab.booking.connection.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PaymentRepository implements EntityRepository<Payment>{
    @Override
    public void add(Payment payment) {
        String query = "INSERT INTO payments (payment_id, ride_id, user_id, amount, payment_method, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, payment.getPaymentId());
            statement.setInt(2, payment.getRideId());
            statement.setInt(3, payment.getUserId());
            statement.setDouble(4, payment.getAmount());
            statement.setString(5, payment.getPaymentMethod());
            statement.setString(6, payment.getStatus());

            statement.executeUpdate();
            System.out.println("Payment added successfully.");
        } catch (SQLException e) {
            System.err.println("Error adding payment: " + e.getMessage());
        }
    }

    @Override
    public List<Payment> getAll() {
        return new ArrayList<>();  // Implement fetching logic
    }

    @Override
    public void update(Payment payment) {
        // Implement update logic
    }

    @Override
    public void delete(int id) {
        // Implement delete logic
    }

    public List<Payment> findAllPayments() {
        return List.of();
    }

    public Optional<Payment> findPaymentById(int paymentId) {
        return Optional.empty();
    }

    public boolean deletePaymentById(int paymentId) {
        return false;
    }

    public boolean updatePayment(Payment payment) {
        return false;
    }
}
