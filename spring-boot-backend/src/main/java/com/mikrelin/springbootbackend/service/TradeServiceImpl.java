package com.mikrelin.springbootbackend.service;

import com.mikrelin.springbootbackend.dao.TradeRepository;
import com.mikrelin.springbootbackend.dao.UserRepository;
import com.mikrelin.springbootbackend.entity.Trade;
import com.mikrelin.springbootbackend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeServiceImpl implements TradeService {
    private TradeRepository tradeRepository;
    private UserRepository userRepository;

    @Autowired
    public TradeServiceImpl(TradeRepository tradeRepository, UserRepository userRepository) {
        this.tradeRepository = tradeRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Trade> findAll() {
        return tradeRepository.findAll();
    }

    @Override
    public Trade findByTradeId(long tradeId) {
        return tradeRepository.findById(tradeId)
                .orElse(null);      // make sure to update not found logic
    }

    @Override
    public List<Trade> findByUserId(long userId) {
        User user = userRepository.findById(userId)
                .orElse(null);
        return tradeRepository.findByUser(user);
    }

    @Override
    public Trade save(Trade trade) {
        return tradeRepository.save(trade);
    }

    @Override
    public void deleteByTradeId(long tradeId) {
        tradeRepository.deleteById(tradeId);
    }
}
