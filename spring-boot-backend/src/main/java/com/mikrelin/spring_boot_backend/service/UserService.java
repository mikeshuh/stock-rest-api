package com.mikrelin.spring_boot_backend.service;

import com.mikrelin.spring_boot_backend.entity.Trade;
import com.mikrelin.spring_boot_backend.entity.User;
import com.mikrelin.spring_boot_backend.entity.UserStock;

import java.util.List;

public interface UserService {

    User findByUsername(String username);

    User save(User user);

    void deleteById(int id);

    List<UserStock> getUserStocks();

    UserStock getUserStockByStockSymbol(String stockSymbol);

    List<Trade> getTrades();
}
