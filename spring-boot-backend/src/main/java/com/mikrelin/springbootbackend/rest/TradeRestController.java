package com.mikrelin.springbootbackend.rest;

import com.mikrelin.springbootbackend.entity.Trade;
import com.mikrelin.springbootbackend.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trade")
public class TradeRestController {
    private TradeService tradeService;

    @Autowired
    public TradeRestController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @GetMapping
    public List<Trade> findAllTrades() {
        return tradeService.findAll();
    }

    @GetMapping("/{tradeId}")
    public Trade findById(@PathVariable long tradeId) {
        return tradeService.findByTradeId(tradeId);
    }

    @GetMapping("/{userId}")
    public List<Trade> findByUserId(@PathVariable long userId) {
        return tradeService.findByUserId(userId);
    }

    @PostMapping
    public Trade addTrade(@RequestBody Trade trade) {
//        trade.setUserId(0);
        return tradeService.save(trade);
    }

    @PutMapping
    public Trade updateTrade(@RequestBody Trade trade) {
        return tradeService.save(trade);
    }

    @DeleteMapping("/{tradeId}")
    public void deleteTrade(@PathVariable long tradeId) {
        tradeService.deleteByTradeId(tradeId);
    }
}
