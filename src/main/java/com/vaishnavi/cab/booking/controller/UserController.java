package com.vaishnavi.cab.booking.controller;


import com.vaishnavi.cab.booking.model.User;
import com.vaishnavi.cab.booking.service.UserService;

import java.util.Scanner;

public class UserController {
    private final UserService userService = new UserService();

    public void manageUsers() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("User Management");
            System.out.println("1. Add User");
            System.out.println("2. View All Users");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter User ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = scanner.nextLine();
                    userService.addUser(new User(id, name, email, phone));
                }
                case 2 -> userService.getAllUsers().forEach(System.out::println);
                case 3 -> {
                    System.out.print("Enter User ID to update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter New Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter New Phone: ");
                    String phone = scanner.nextLine();
                    userService.updateUser(new User(id, name, email, phone));
                }
                case 4 -> {
                    System.out.print("Enter User ID to delete: ");
                    int id = scanner.nextInt();
                    userService.deleteUser(id);
                }
                case 5 -> System.out.println("Exiting User Management...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    public void addUser() {
    }

    public void displayAllUsers() {
    }

    public void findUserById() {
    }

    public void updateUser() {
    }

    public void deleteUser() {
    }
}


