package com.vaishnavi.cab.booking.controller;


import com.vaishnavi.cab.booking.model.User;
import com.vaishnavi.cab.booking.service.UserService;

import java.util.List;

public class UserController {
    private final UserService userService = new UserService();

    public void addUser(User user) {
        try {
            userService.addUser(user);
            System.out.println("User added successfully.");
        } catch (Exception e) {
            System.err.println("Error adding user: " + e.getMessage());
        }
    }

    public void getAllUsers() {
        try {
            List<User> users = userService.getAllUsers();
            users.forEach(System.out::println);
        } catch (Exception e) {
            System.err.println("Error fetching users: " + e.getMessage());
        }
    }

    public void updateUser(User user) {
        try {
            userService.updateUser(user);
            System.out.println("User updated successfully.");
        } catch (Exception e) {
            System.err.println("Error updating user: " + e.getMessage());
        }
    }

    public void deleteUser(int userId) {
        try {
            userService.deleteUser(userId);
            System.out.println("User deleted successfully.");
        } catch (Exception e) {
            System.err.println("Error deleting user: " + e.getMessage());
        }
    }
}


