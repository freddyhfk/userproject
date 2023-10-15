package com.example.userproject.service;

import com.example.userproject.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getUserByName(String name);

    List<User> getAllUsers();

    User getUserById(Long id);

    void updateUser(User user, Long id);

    void deleteUserById(Long id);
}
