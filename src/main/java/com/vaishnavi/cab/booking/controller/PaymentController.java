package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Payment;
import com.vaishnavi.cab.booking.service.PaymentService;

import java.util.List;

public class PaymentController {
    private final PaymentService paymentService = new PaymentService();

    public void addPayment(Payment payment) {
        try {
            paymentService.addPayment(payment);
            System.out.println("Payment added successfully.");
        } catch (Exception e) {
            System.err.println("Error adding payment: " + e.getMessage());
        }
    }

    public void getAllPayments() {
        try {
            List<Payment> payments = paymentService.getAllPayments();
            payments.forEach(System.out::println);
        } catch (Exception e) {
            System.err.println("Error fetching payments: " + e.getMessage());
        }
    }

    public void updatePayment(Payment payment) {
        try {
            paymentService.updatePayment(payment);
            System.out.println("Payment updated successfully.");
        } catch (Exception e) {
            System.err.println("Error updating payment: " + e.getMessage());
        }
    }

    public void deletePayment(int paymentId) {
        try {
            paymentService.deletePayment(paymentId);
            System.out.println("Payment deleted successfully.");
        } catch (Exception e) {
            System.err.println("Error deleting payment: " + e.getMessage());
        }
    }
}
