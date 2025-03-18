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


    }


