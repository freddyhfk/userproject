package com.example.userproject.service;

import com.example.userproject.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getUserByName(String name);

    User updateUser(User user, Long id);

    void deleteUserById(Long id);

}
