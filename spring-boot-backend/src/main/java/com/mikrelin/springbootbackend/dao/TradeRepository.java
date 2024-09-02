package com.mikrelin.springbootbackend.dao;

import com.mikrelin.springbootbackend.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepository extends JpaRepository<Trade, Integer> {
}
