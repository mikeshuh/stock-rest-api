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
    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

    @Override
    public Stock findByStockId(long stockId) {
        return stockRepository.findById(stockId)
                .orElse(null);      // make sure to update not found logic
    }

    @Override
    public List<Stock> findByTicker(String ticker) {
        return stockRepository.findByTicker(ticker);
    }

    @Override
    public List<Stock> findByCompanyName(String companyName) {
        return stockRepository.findByCompanyName(companyName);
    }

    @Override
    public Stock findByExchangeAndTicker(String exchange, String ticker) {
        return stockRepository.findByExchangeAndTicker(exchange, ticker)
                .orElse(null);      // make sure to update not found logic
    }

    @Override
    public Stock save(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public void deleteByStockId(long stockId) {
        stockRepository.deleteById(stockId);
    }
}
