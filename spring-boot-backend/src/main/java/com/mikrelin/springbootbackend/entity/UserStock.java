package com.mikrelin.springbootbackend.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "user_stock")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "userStockId"
)
public class UserStock {
    @EmbeddedId
    private UserStockId userStockId;

    @Column(name = "allocated_amount")
    private double allocatedAmount;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    @Column(name = "last_updated")
    private Timestamp lastUpdated;

    public UserStock() {}

    public UserStock(User user, Stock stock, double allocatedAmount, int quantity, double price) {
        this.userStockId = new UserStockId(user, stock);
        this.allocatedAmount = allocatedAmount;
        this.quantity = quantity;
        this.price = price;
        this.lastUpdated = new Timestamp(System.currentTimeMillis());
        this.userStockId = new UserStockId(user, stock);

    }

    public UserStockId getUserStockId() {
        return userStockId;
    }

    public void setUserStockId(UserStockId userStockId) {
        this.userStockId = userStockId;
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

    @Override
    public String toString() {
        return "UserStock{" +
                "userStockId=" + userStockId +
                ", allocatedAmount=" + allocatedAmount +
                ", quantity=" + quantity +
                ", price=" + price +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
