package com.mikrelin.springbootbackend.service;

import com.mikrelin.springbootbackend.entity.Trade;

import java.util.List;

public interface TradeService {

    Trade save(Trade trade);

    void deleteByTradeId(int id);

    List<Trade> findByUserId(int UserId);
}
