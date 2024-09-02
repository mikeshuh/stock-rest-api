package com.mikrelin.spring_boot_backend.service;

import com.mikrelin.spring_boot_backend.entity.UserStock;

import java.util.List;

public interface UserStockService {

    UserStock save(UserStock userStock);

    void deleteById(int id);
}
