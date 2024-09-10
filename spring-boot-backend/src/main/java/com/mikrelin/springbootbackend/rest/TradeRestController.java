package com.mikrelin.springbootbackend.rest;

import com.mikrelin.springbootbackend.dto.TradeDTO;
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
    public List<TradeDTO> findAllTrades() {
        return tradeService.findAll();
    }

    @GetMapping("/id/{tradeId}")
    public TradeDTO findById(@PathVariable long tradeId) {
        return tradeService.findByTradeId(tradeId);
    }

    @GetMapping("/user/{userId}")
    public List<TradeDTO> findByUserId(@PathVariable long userId) {
        return tradeService.findByUserId(userId);
    }

    @PostMapping
    public TradeDTO addTrade(@RequestBody Trade trade) {
        trade.setTradeId(0);
        return tradeService.save(trade);
    }

    @PutMapping
    public TradeDTO updateTrade(@RequestBody Trade trade) {
        return tradeService.save(trade);
    }

    @DeleteMapping("/{tradeId}")
    public void deleteTrade(@PathVariable long tradeId) {
        tradeService.deleteByTradeId(tradeId);
    }
}
