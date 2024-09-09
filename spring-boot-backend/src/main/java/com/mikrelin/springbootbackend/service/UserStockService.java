package com.mikrelin.springbootbackend.service;

import com.mikrelin.springbootbackend.entity.UserStock;

import java.util.List;

public interface UserStockService {
    List<UserStock> findAll();

    List<UserStock> findByUserId(long userId);

    UserStock findByUserIdAndStockId(long userId, long stockId);

    UserStock save(UserStock userStock);

    void deleteByUserIdAndStockId(long userId, long stockId);
}
