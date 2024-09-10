package com.mikrelin.springbootbackend.rest;

import com.mikrelin.springbootbackend.entity.Stock;
import com.mikrelin.springbootbackend.service.StockService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
public class StockRestController {
    private StockService stockService;

    public StockRestController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public List<Stock> findAllStocks() {
        return stockService.findAll();
    }

    @GetMapping("/id/{stockId}")
    public Stock findById(@PathVariable long stockId) {
        return stockService.findByStockId(stockId);
    }

    @GetMapping("/ticker/{ticker}")
    public List<Stock> findByTicker(@PathVariable String ticker) {
        return stockService.findByTicker(ticker);
    }

    @GetMapping("/company/{companyName}")
    public List<Stock> findByCompanyName(@PathVariable String companyName) {
        return stockService.findByCompanyName(companyName);
    }

    @GetMapping("/{exchange}/{ticker}")
    public Stock findByExchangeAndTicker(@PathVariable String exchange, @PathVariable String ticker) {
        return stockService.findByExchangeAndTicker(exchange, ticker);
    }

    @PostMapping
    public Stock addStock(@RequestBody Stock stock) {
        stock.setStockId(0);
        return stockService.save(stock);
    }

    @PutMapping()
    public Stock updateStock(@RequestBody Stock stock) {
        return stockService.save(stock);
    }

    @DeleteMapping("/{stockId}")
    public void deleteStock(@PathVariable long stockId) {
        stockService.deleteByStockId(stockId);
    }
}
