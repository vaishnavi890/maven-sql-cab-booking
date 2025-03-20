package com.vaishnavi.cab.booking.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data

    public class User {
        private int userId;
        private String name;
        private String email;
        private String phone;


    public int getUserId() {
        return 0;
    }

    public String getName() {
        return "";
    }

    public String getEmail() {
        return "";
    }

    public String getPhone() {
        return "";
    }
}

