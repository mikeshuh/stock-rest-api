package com.mikrelin.spring_boot_backend.service;

import com.mikrelin.spring_boot_backend.entity.Trade;

public interface TradeService {

    Trade save(Trade trade);

    void deleteById(int id);
}
