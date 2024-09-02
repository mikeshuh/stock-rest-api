package com.mikrelin.spring_boot_backend.dao;

import com.mikrelin.spring_boot_backend.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepository extends JpaRepository<Trade, Integer> {
}
