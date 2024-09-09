package com.mikrelin.springbootbackend.service;

import com.mikrelin.springbootbackend.entity.Trade;

import java.util.List;

public interface TradeService {
    List<Trade> findAll();

    Trade findByTradeId(long tradeId);

    List<Trade> findByUserId(long userId);

    Trade save(Trade trade);

    void deleteByTradeId(long tradeId);
}
