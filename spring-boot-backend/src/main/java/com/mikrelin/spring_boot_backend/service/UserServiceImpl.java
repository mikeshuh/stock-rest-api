package com.mikrelin.spring_boot_backend.service;

import com.mikrelin.spring_boot_backend.entity.Trade;
import com.mikrelin.spring_boot_backend.entity.User;
import com.mikrelin.spring_boot_backend.entity.UserStock;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<UserStock> getUserStocks() {
        return List.of();
    }

    @Override
    public UserStock getUserStockByStockSymbol(String stockSymbol) {
        return null;
    }

    @Override
    public List<Trade> getTrades() {
        return List.of();
    }
}
