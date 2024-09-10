package com.mikrelin.springbootbackend.dto;

import java.sql.Timestamp;

public class UserStockDTO {
    private long userId;
    private long stockId;
    private double allocatedAmount;
    private int quantity;
    private double price;
    private Timestamp lastUpdated;

    public UserStockDTO() {}

    public UserStockDTO(long userId, long stockId, double allocatedAmount, int quantity, double price, Timestamp lastUpdated) {
        this.userId = userId;
        this.stockId = stockId;
        this.allocatedAmount = allocatedAmount;
        this.quantity = quantity;
        this.price = price;
        this.lastUpdated = lastUpdated;
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

    public double getAllocatedAmount() {
        return allocatedAmount;
    }

    public void setAllocatedAmount(double allocatedAmount) {
        this.allocatedAmount = allocatedAmount;
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

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}

