package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Payment;
import com.vaishnavi.cab.booking.repository.PaymentRepository;

import java.util.List;
import java.util.Optional;

public class PaymentService {
    private PaymentRepository paymentRepository = new PaymentRepository();

    public List<Payment> getAllPayments() {
        List<Payment> payments = paymentRepository.findAllPayments();
        payments.forEach(System.out::println);
        return payments;
    }

    public void findPaymentById(int paymentId) {
        Optional<Payment> payment = paymentRepository.findPaymentById(paymentId);
        payment.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Payment with ID " + paymentId + " not found!")
        );
    }

    public void deletePaymentById(int paymentId) {
        if (!paymentRepository.deletePaymentById(paymentId)) {
            System.out.println("Payment deletion failed!");
        }
    }

    public void updatePayment(Payment payment) {
        if (!paymentRepository.updatePayment(payment)) {
            System.out.println("Payment update failed!");
        }
    }

    public void registerPayment(Payment payment) {
    }

    public void addPayment(Payment payment) {
    }

    public void deletePayment(int paymentId) {
    }
}


