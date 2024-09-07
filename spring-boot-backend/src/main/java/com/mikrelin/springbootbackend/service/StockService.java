package com.mikrelin.springbootbackend.service;

import com.mikrelin.springbootbackend.entity.Stock;

import java.util.List;

public interface StockService {

    Stock save(Stock stock);

    void deleteByStockId(int id);

    List<Stock> findByUserId(int userId);
}
