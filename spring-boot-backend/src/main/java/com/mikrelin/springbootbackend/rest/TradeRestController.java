package com.mikrelin.springbootbackend.rest;

import com.mikrelin.springbootbackend.dao.TradeRepository;
import com.mikrelin.springbootbackend.entity.Trade;
import com.mikrelin.springbootbackend.service.TradeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trade")
public class TradeRestController {

    private TradeService tradeService;

    public TradeRestController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @GetMapping("/{userId}")
    public List<Trade> findAllByUserId(@PathVariable int userId) {
        return tradeService.findByUserId(userId);
    }

    @PostMapping()
    public Trade addTrade(@RequestBody Trade trade) {
        trade.setId(0);
        return tradeService.save(trade);
    }

    @PutMapping()
    public Trade updateTrade(@RequestBody Trade trade) {
        return tradeService.save(trade);
    }

    @DeleteMapping("/{id}")
    public void deleteTrade(@PathVariable int id) {
        tradeService.deleteByTradeId(id);
    }


}
