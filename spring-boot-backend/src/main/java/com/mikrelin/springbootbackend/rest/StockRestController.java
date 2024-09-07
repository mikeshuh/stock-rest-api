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

    @GetMapping("/{userId}")
    public List<Stock> findStockByUserId(@PathVariable int userId) {
        return stockService.findByUserId(userId);
    }

    @PostMapping()
    public Stock addStock(@RequestBody Stock stock) {
        stock.setId(0);

        return stockService.save(stock);
    }

    @PutMapping()
    public Stock updateStock(@RequestBody Stock stock) {
        return stockService.save(stock);
    }

    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable int id) {
        stockService.deleteByStockId(id);
    }
}
