package com.mikrelin.springbootbackend.service;

import com.mikrelin.springbootbackend.dao.StockRepository;
import com.mikrelin.springbootbackend.dao.UserRepository;
import com.mikrelin.springbootbackend.dao.UserStockRepository;
import com.mikrelin.springbootbackend.entity.Stock;
import com.mikrelin.springbootbackend.entity.User;
import com.mikrelin.springbootbackend.entity.UserStock;
import com.mikrelin.springbootbackend.entity.UserStockId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStockServiceImpl implements UserStockService {
    private UserStockRepository userStockRepository;
    private UserRepository userRepository;
    private StockRepository stockRepository;

    @Autowired
    public UserStockServiceImpl(UserStockRepository userStockRepository, UserRepository userRepository, StockRepository stockRepository) {
        this.userStockRepository = userStockRepository;
        this.userRepository = userRepository;
        this.stockRepository = stockRepository;
    }

    @Override
    public List<UserStock> findAll() {
        return userStockRepository.findAll();
    }

    @Override
    public List<UserStock> findByUserId(long userId) {
        User user = userRepository.findById(userId)
                .orElse(null);
        return userStockRepository.findByUserStockId_User(user);
    }

    @Override
    public UserStock findByUserIdAndStockId(long userId, long stockId) {
        User user = userRepository.findById(userId)
                .orElse(null);
        Stock stock = stockRepository.findById(stockId)
                .orElse(null);
        return userStockRepository.findById(new UserStockId(user, stock))
                .orElse(null);      // make sure to update not found logic
    }

    @Override
    public UserStock save(UserStock userStock) {
        return userStockRepository.save(userStock);
    }

    @Override
    public void deleteByUserIdAndStockId(long userId, long stockId) {
        User user = userRepository.findById(userId)
                .orElse(null);
        Stock stock = stockRepository.findById(stockId)
                .orElse(null);
        userStockRepository.deleteById(new UserStockId(user, stock));
    }
}
