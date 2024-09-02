package com.mikrelin.springbootbackend.service;

import com.mikrelin.springbootbackend.entity.Trade;
import com.mikrelin.springbootbackend.entity.User;
import com.mikrelin.springbootbackend.entity.UserStock;

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
