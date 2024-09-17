package com.mikrelin.springbootbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "stock",
        uniqueConstraints = @UniqueConstraint(columnNames = {"ticker", "exchange"})
)
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    private long stockId;

    @Column(name = "ticker")
    private String ticker;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "exchange")
    private String exchange;

    @OneToMany(
            mappedBy = "userStockId.stock",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JsonIgnore
    private List<UserStock> userStocks;

    @OneToMany(
            mappedBy = "stock",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JsonIgnore
    private List<Trade> trades;

    public Stock() {}

    public Stock(String ticker, String companyName, String exchange) {
        this.ticker = ticker;
        this.companyName = companyName;
        this.exchange = exchange;
    }

    public long getStockId() {
        return stockId;
    }

    public void setStockId(long stockId) {
        this.stockId = stockId;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public List<UserStock> getUserStocks() {
        return userStocks;
    }

    public void setUserStocks(List<UserStock> userStocks) {
        this.userStocks = userStocks;
    }

    public void addUserStock(UserStock userStock) {
        if (this.userStocks == null) {
            this.userStocks = new ArrayList<>();
        }
        this.userStocks.add(userStock);
    }

    public List<Trade> getTrades() {
        return trades;
    }

    public void setTrades(List<Trade> trades) {
        this.trades = trades;
    }

    public void addTrade(Trade trade) {
        if (this.trades == null) {
            this.trades = new ArrayList<>();
        }
        this.trades.add(trade);
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockId=" + stockId +
                ", ticker='" + ticker + '\'' +
                ", companyName='" + companyName + '\'' +
                ", exchange='" + exchange + '\'' +
                '}';
    }
}
