package com.mikrelin.springbootbackend.service;

import com.mikrelin.springbootbackend.entity.Stock;

import java.util.List;

public interface StockService {
    List<Stock> findAll();

    Stock findByStockId(long stockId);

    List<Stock> findByTicker(String ticker);

    List<Stock> findByCompanyName(String companyName);

    Stock findByExchangeAndTicker(String exchange, String ticker);

    Stock save(Stock stock);

    void deleteByStockId(long stockId);
}