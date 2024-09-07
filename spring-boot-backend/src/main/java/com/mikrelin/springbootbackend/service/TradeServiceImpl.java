package com.mikrelin.springbootbackend.service;

import com.mikrelin.springbootbackend.dao.TradeRepository;
import com.mikrelin.springbootbackend.entity.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeServiceImpl implements TradeService {

    private TradeRepository tradeRepository;

    @Autowired
    public TradeServiceImpl(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    @Override
    public Trade save(Trade trade) {
        return tradeRepository.save(trade);
    }

    @Override
    public void deleteByTradeId(int id) {
        tradeRepository.deleteById(id);
    }

    @Override
    public List<Trade> findByUserId(int UserId) {
        return tradeRepository.findByUserId(UserId);
    }
}
