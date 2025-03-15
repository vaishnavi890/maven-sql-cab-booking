package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.User;
import com.vaishnavi.cab.booking.repository.UserRepository;

import java.util.List;
import java.util.Optional;


public class UserService {
    private UserRepository userRepository = new UserRepository();

    public void registerUser(User user) {
        userRepository.saveUser(user);
    }

    public void getAllUsers() {
        List<User> users = userRepository.findAllUsers();
        users.forEach(System.out::println);
    }

    public void findUserById(int userId) {
        Optional<User> user = userRepository.findUserById(userId);
        user.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("User with ID " + userId + " not found!")
        );
    }

    public void deleteUserById(int userId) {
        if (!userRepository.deleteUserById(userId)) {
            System.out.println("User deletion failed!");
        }
    }

    public void updateUser(User user) {
        if (!userRepository.updateUser(user)) {
            System.out.println("User update failed!");
        }
    }
}

