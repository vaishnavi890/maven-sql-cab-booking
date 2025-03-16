package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.repository.UserRepository;

public class UserService {
    private UserRepository userRepository = new UserRepository();

    public void registerUser(Users user) {
        try {
            userRepository.addUser(user);
            System.out.println("User registered successfully.");
        } catch (Exception e) {
            System.err.println("Registration failed: " + e.getMessage());
        }
    }
}
