package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.User;
import com.vaishnavi.cab.booking.service.UserService;

import java.util.Scanner;

public class UserController {
    private UserService userService = new UserService();
    private Scanner scanner = new Scanner(System.in);

    public void addUser() {
        System.out.println("Enter User ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Email: ");
        String email = scanner.nextLine();
        System.out.println("Enter Phone: ");
        String phone = scanner.nextLine();

        User user = new User(userId, name, email, phone);
        userService.registerUser(user);
    }

    public void displayAllUsers() {
        System.out.println("All Registered Users:");
        userService.getAllUsers();
    }

    public void findUserById() {
        System.out.println("Enter User ID to search: ");
        int userId = scanner.nextInt();
        userService.findUserById(userId);
    }

    public void deleteUser() {
        System.out.println("Enter User ID to delete: ");
        int userId = scanner.nextInt();
        userService.deleteUserById(userId);
    }

    public void updateUser() {
        System.out.println("Enter User ID to update: ");
        int userId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter New Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter New Email: ");
        String email = scanner.nextLine();
        System.out.println("Enter New Phone: ");
        String phone = scanner.nextLine();

        User user = new User(userId, name, email, phone);
        userService.updateUser(user);
    }
}

