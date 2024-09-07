package com.mikrelin.springbootbackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}
    )
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @Column(name = "stock_symbol")
    private String stockSymbol;

    public Stock() {}

    public Stock(User user, String stockSymbol) {
        this.user = user;
        this.stockSymbol = stockSymbol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    @Override
    public String toString() {
        return "UserStock{" +
                "id=" + id +
                ", user=" + user +
                ", stockSymbol='" + stockSymbol + '\'' +
                '}';
    }
}
