package com.mikrelin.springbootbackend.service;

import com.mikrelin.springbootbackend.entity.Trade;

public interface TradeService {

    Trade save(Trade trade);

    void deleteById(int id);
}
