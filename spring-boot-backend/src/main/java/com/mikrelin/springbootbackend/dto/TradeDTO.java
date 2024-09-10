package com.mikrelin.springbootbackend.dto;

import java.sql.Timestamp;

public class TradeDTO {
    private long tradeId;
    private long userId;
    private long stockId;
    private String tradeType;
    private int quantity;
    private double price;
    private Timestamp timeExecuted;

    public TradeDTO() {}

    public TradeDTO(long tradeId, long userId, long stockId, String tradeType, int quantity, double price, Timestamp timeExecuted) {
        this.tradeId = tradeId;
        this.userId = userId;
        this.stockId = stockId;
        this.tradeType = tradeType;
        this.quantity = quantity;
        this.price = price;
        this.timeExecuted = timeExecuted;
    }

    public long getTradeId() {
        return tradeId;
    }

    public void setTradeId(long tradeId) {
        this.tradeId = tradeId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getStockId() {
        return stockId;
    }

    public void setStockId(long stockId) {
        this.stockId = stockId;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Timestamp getTimeExecuted() {
        return timeExecuted;
    }

    public void setTimeExecuted(Timestamp timeExecuted) {
        this.timeExecuted = timeExecuted;
    }
}
