package com.mikrelin.springbootbackend.dao;

import com.mikrelin.springbootbackend.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Integer> {

    List<Stock> findByUserId(int userId);
}
