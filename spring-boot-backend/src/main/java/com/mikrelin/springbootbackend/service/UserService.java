package com.mikrelin.springbootbackend.service;

import com.mikrelin.springbootbackend.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findByUserId(long userId);

    User findByUsername(String username);

    User save(User user);

    void deleteByUserId(long userId);
}
