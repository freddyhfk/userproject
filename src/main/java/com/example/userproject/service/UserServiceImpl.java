package com.example.userproject.service;

import com.example.userproject.entity.User;
import com.example.userproject.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
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
    public List<User> getAllUsers() {
        return IteratorUtils.toList(userRepository.findAll().iterator());
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> userDb = userRepository.findById(id);
        return userDb.orElse(null);
    }

    @Override
    public void updateUser(User user, Long id) throws EntityNotFoundException {

         userRepository
                .findById(user.getId())
                .ifPresent(dbUser -> {
                    dbUser.setName(user.getName());
                    dbUser.setSurname(user.getSurname());
                    dbUser.setEmail(user.getEmail());

                    userRepository.save(dbUser);
                });
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
