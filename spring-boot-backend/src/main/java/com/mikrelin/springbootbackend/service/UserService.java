package com.mikrelin.springbootbackend.service;

import com.mikrelin.springbootbackend.entity.Trade;
import com.mikrelin.springbootbackend.entity.User;
import com.mikrelin.springbootbackend.entity.UserStock;

import java.util.List;

public interface UserService {

    User findByUsername(String username);

    User save(User user);

    void deleteById(int id);

    List<UserStock> getUserStocks();

    UserStock getUserStockByStockSymbol(String stockSymbol);

    List<Trade> getTrades();
}
