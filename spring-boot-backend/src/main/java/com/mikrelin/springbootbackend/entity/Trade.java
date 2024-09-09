package com.mikrelin.springbootbackend.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "trade")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "tradeId"
)
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trade_id")
    private long tradeId;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}
    )
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}
    )
    @JoinColumn(name = "stock_id")
    private Stock stock;

    @Column(name = "trade_type")
    private String tradeType;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    @Column(name = "time_executed")
    private Timestamp timeExecuted;

    public Trade() {}

    public Trade(User user, Stock stock, String tradeType, int quantity, double price) {
        this.user = user;
        this.stock = stock;
        this.tradeType = tradeType;
        this.quantity = quantity;
        this.price = price;
        this.timeExecuted = new Timestamp(System.currentTimeMillis());
    }

    public long getTradeId() {
        return tradeId;
    }

    public void setTradeId(long tradeId) {
        this.tradeId = tradeId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
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

    @Override
    public String toString() {
        return "Trade{" +
                "tradeId=" + tradeId +
                ", user=" + user +
                ", stock=" + stock +
                ", tradeType='" + tradeType + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", timeExecuted=" + timeExecuted +
                '}';
    }
}
