package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class UserRepository {
    private List<User> users = new ArrayList<>();

    // Save a new user
    public void saveUser(User user) {
        users.add(user);
        System.out.println("User saved successfully: " + user);
    }

    // Get all users
    public List<User> findAllUsers() {
        return new ArrayList<>(users);
    }

    // Find user by ID using Stream and Optional
    public Optional<User> findUserById(int userId) {
        return users.stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst();
    }

    // Find users by name (example of using Predicate)
    public List<User> findUsersByName(String name) {
        return users.stream()
                .filter(user -> user.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    // Remove user by ID using Stream and Predicate
    public boolean deleteUserById(int userId) {
        Predicate<User> predicate = user -> user.getUserId() == userId;
        boolean removed = users.removeIf(predicate);
        if (removed) {
            System.out.println("User with ID " + userId + " removed successfully!");
        } else {
            System.out.println("User with ID " + userId + " not found!");
        }
        return removed;
    }

    // Update user details
    public boolean updateUser(User updatedUser) {
        Optional<User> existingUser = findUserById(updatedUser.getUserId());
        existingUser.ifPresent(user -> {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setPhone(updatedUser.getPhone());
            System.out.println("User updated successfully: " + user);
        });
        return existingUser.isPresent();
    }
}
