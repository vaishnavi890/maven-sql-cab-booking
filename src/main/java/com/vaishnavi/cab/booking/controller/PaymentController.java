package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Payment;
import com.vaishnavi.cab.booking.service.PaymentService;

import java.util.Scanner;

public class PaymentController {
    private PaymentService paymentService = new PaymentService();
    private Scanner scanner = new Scanner(System.in);

    public void addPayment() {
        System.out.println("Enter Payment ID: ");
        int paymentId = scanner.nextInt();
        System.out.println("Enter Ride ID: ");
        int rideId = scanner.nextInt();
        System.out.println("Enter User ID: ");
        int userId = scanner.nextInt();
        System.out.println("Enter Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter Payment Method: ");
        String paymentMethod = scanner.nextLine();
        System.out.println("Enter Payment Status: ");
        String status = scanner.nextLine();

        Payment payment = new Payment(paymentId, rideId, userId, amount, paymentMethod, status);
        paymentService.registerPayment(payment);
    }

    public void displayAllPayments() {
        System.out.println("All Payments:");
        paymentService.getAllPayments();
    }

    public void findPaymentById() {
        System.out.println("Enter Payment ID to search: ");
        int paymentId = scanner.nextInt();
        paymentService.findPaymentById(paymentId);
    }

    public void deletePayment() {
        System.out.println("Enter Payment ID to delete: ");
        int paymentId = scanner.nextInt();
        paymentService.deletePaymentById(paymentId);
    }

    public void updatePayment() {
        System.out.println("Enter Payment ID to update: ");
        int paymentId = scanner.nextInt();
        System.out.println("Enter New Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter New Payment Method: ");
        String paymentMethod = scanner.nextLine();
        System.out.println("Enter New Payment Status: ");
        String status = scanner.nextLine();

        Payment payment = new Payment(paymentId, 0, 0, amount, paymentMethod, status);
        paymentService.updatePayment(payment);
    }
}
