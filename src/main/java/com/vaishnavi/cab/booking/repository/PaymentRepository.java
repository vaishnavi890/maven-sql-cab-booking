package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Payment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class PaymentRepository {
    private List<Payment> payments = new ArrayList<>();

    // Save a new payment
    public void savePayment(Payment payment) {
        payments.add(payment);
        System.out.println("Payment saved successfully: " + payment);
    }

    // Get all payments
    public List<Payment> findAllPayments() {
        return new ArrayList<>(payments);
    }

    // Find payment by ID
    public Optional<Payment> findPaymentById(int paymentId) {
        return payments.stream()
                .filter(payment -> payment.getPaymentId() == paymentId)
                .findFirst();
    }

    // Remove payment by ID
    public boolean deletePaymentById(int paymentId) {
        Predicate<Payment> predicate = payment -> payment.getPaymentId() == paymentId;
        boolean removed = payments.removeIf(predicate);
        if (removed) {
            System.out.println("Payment with ID " + paymentId + " removed successfully!");
        } else {
            System.out.println("Payment with ID " + paymentId + " not found!");
        }
        return removed;
    }

    // Update payment details
    public boolean updatePayment(Payment updatedPayment) {
        Optional<Payment> existingPayment = findPaymentById(updatedPayment.getPaymentId());
        existingPayment.ifPresent(payment -> {
            payment.setAmount(updatedPayment.getAmount());
            payment.setPaymentMethod(updatedPayment.getPaymentMethod());
            payment.setStatus(updatedPayment.getStatus());
            System.out.println("Payment updated successfully: " + payment);
        });
        return existingPayment.isPresent();
    }
}
