package com.mikrelin.springbootbackend.service;

import com.mikrelin.springbootbackend.dto.UserStockDTO;
import com.mikrelin.springbootbackend.entity.UserStock;

import java.util.List;

public interface UserStockService {
    List<UserStockDTO> findAll();

    List<UserStockDTO> findByUserId(long userId);

    UserStockDTO findByUserIdAndStockId(long userId, long stockId);

    UserStockDTO save(UserStockDTO userStockDTO);

    void deleteByUserIdAndStockId(long userId, long stockId);
}
