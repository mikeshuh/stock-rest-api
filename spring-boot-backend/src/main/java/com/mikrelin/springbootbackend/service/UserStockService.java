package com.mikrelin.springbootbackend.service;

import com.mikrelin.springbootbackend.entity.UserStock;

public interface UserStockService {

    UserStock save(UserStock userStock);

    void deleteById(int id);
}
