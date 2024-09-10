package com.mikrelin.springbootbackend.service;

import com.mikrelin.springbootbackend.dto.TradeDTO;
import com.mikrelin.springbootbackend.entity.Trade;

import java.util.List;

public interface TradeService {
    List<TradeDTO> findAll();

    TradeDTO findByTradeId(long tradeId);

    List<TradeDTO> findByUserId(long userId);

    TradeDTO save(Trade trade);

    void deleteByTradeId(long tradeId);
}
