package com.vaishnavi.cab.booking.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data

    public class Payment {
        private int paymentId;
        private int rideId;
        private int userId;
        private double amount;
        private String paymentMethod;
        private String status;

    public Payment(int paymentId, int rideId, int userId, double amount, String method, String status) {
    }


    public int getPaymentId() {
        return 0;
    }

    public int getRideId() {
        return 0;
    }

    public int getUserId() {
        return 0;
    }

    public double getAmount() {
        return 0;
    }

    public String getPaymentMethod() {
        return "";
    }

    public String getStatus() {
        return "";
    }
}


