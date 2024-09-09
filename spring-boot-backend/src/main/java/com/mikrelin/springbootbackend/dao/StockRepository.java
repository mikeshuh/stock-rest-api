package com.mikrelin.springbootbackend.dao;

import com.mikrelin.springbootbackend.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {
    List<Stock> findByTicker(String ticker);

    List<Stock> findByCompanyName(String companyName);

    Optional<Stock> findByExchangeAndTicker(String exchange, String ticker);
}
