package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.User;
import com.vaishnavi.cab.booking.repository.UserRepository;

import java.util.*;
import java.util.stream.Collectors;

    public class UserService {
        private List<User> users = new ArrayList<>();

        // Register a new user
        public void registerUser(User user) {
            try {
                users.add(user);
                System.out.println("User registered successfully: " + user);
            } catch (Exception e) {
                System.err.println("Error while registering user: " + e.getMessage());
            }
        }

        // Get all users
        public void getAllUsers() {
            try {
                if (users.isEmpty()) {
                    System.out.println("No users found.");
                } else {
                    users.forEach(System.out::println);
                }
            } catch (Exception e) {
                System.err.println("Error while fetching users: " + e.getMessage());
            }
        }

        // Find user by ID
        public void findUserById(int userId) {
            try {
                Optional<User> user = users.stream()
                        .filter(u -> u.getUserId() == userId)
                        .findFirst();

                if (user.isPresent()) {
                    System.out.println("User found: " + user.get());
                } else {
                    System.out.println("User with ID " + userId + " not found.");
                }
            } catch (Exception e) {
                System.err.println("Error while finding user: " + e.getMessage());
            }
        }

        // Delete user by ID
        public void deleteUserById(int userId) {
            try {
                boolean removed = users.removeIf(u -> u.getUserId() == userId);
                if (removed) {
                    System.out.println("User with ID " + userId + " deleted successfully.");
                } else {
                    System.out.println("User with ID " + userId + " not found.");
                }
            } catch (Exception e) {
                System.err.println("Error while deleting user: " + e.getMessage());
            }
        }

        // Update user information
        public void updateUser(User updatedUser) {
            try {
                boolean updated = false;
                for (int i = 0; i < users.size(); i++) {
                    if (users.get(i).getUserId() == updatedUser.getUserId()) {
                        users.set(i, updatedUser);
                        System.out.println("User updated successfully: " + updatedUser);
                        updated = true;
                        break;
                    }
                }
                if (!updated) {
                    System.out.println("User with ID " + updatedUser.getUserId() + " not found.");
                }
            } catch (Exception e) {
                System.err.println("Error while updating user: " + e.getMessage());
            }
        }

        // Display all users
        public void displayAllUsers() {
            try {
                if (users.isEmpty()) {
                    System.out.println("No users to display.");
                } else {
                    users.forEach(user -> System.out.println(user));
                }
            } catch (Exception e) {
                System.err.println("Error while displaying users: " + e.getMessage());
            }
        }
    }