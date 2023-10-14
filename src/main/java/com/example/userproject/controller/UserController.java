package com.example.userproject.controller;

import com.example.userproject.entity.User;
import com.example.userproject.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping("/{name}")
    public List<User> getUserByName(@PathVariable("name") String name) {
        return userService.getUserByName(name);
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(user, id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "Successfully deleted";
    }


}
