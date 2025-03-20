package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.User;
import com.vaishnavi.cab.booking.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private final UserRepository userRepository = new UserRepository();

    public void addUser(User user) {
        userRepository.add(user);
    }

    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    public List<User> searchUsersByName(String name) {
        return userRepository.getAll().stream()
                .filter(user -> user.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public void updateUser(User user) {
        userRepository.update(user);
    }

    public void deleteUser(int userId) {
        userRepository.delete(userId);
    }
}
