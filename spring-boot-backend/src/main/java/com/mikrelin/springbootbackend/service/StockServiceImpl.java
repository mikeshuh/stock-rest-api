package com.mikrelin.springbootbackend.service;

import com.mikrelin.springbootbackend.dao.StockRepository;
import com.mikrelin.springbootbackend.entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    private StockRepository stockRepository;

    @Autowired
    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Stock save(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public void deleteByStockId(int id) {
        stockRepository.deleteById(id);
    }

    @Override
    public List<Stock> findByUserId(int userId) {
        return stockRepository.findByUserId(userId);
    }
}
