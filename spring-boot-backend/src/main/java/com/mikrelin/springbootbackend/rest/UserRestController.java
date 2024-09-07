package com.mikrelin.springbootbackend.rest;

import com.mikrelin.springbootbackend.entity.User;
import com.mikrelin.springbootbackend.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> findAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{username}")
    public User findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @PostMapping()
    public User addUser(@RequestBody User user) {
        user.setId(0);
        return userService.save(user);
    }

    @PutMapping()
    public User updateUser(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userService.deleteByUserId(userId);
    }
}
