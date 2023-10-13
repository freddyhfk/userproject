package com.example.userproject.service;

import com.example.userproject.entity.User;
import com.example.userproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    @Override
    public User updateUser(User user, Long id) {

        User userDb = userRepository.findById(id).get();

        if (Objects.nonNull(user.getName()) && !"".equalsIgnoreCase(user.getName())) {
            userDb.setName(user.getName());
        }

        if (Objects.nonNull(user.getSurname()) && !"".equalsIgnoreCase(user.getSurname())) {
            userDb.setSurname(user.getSurname());
        }

        if (Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getEmail())) {
            userDb.setEmail(user.getEmail());
        }

        return userRepository.save(userDb);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
