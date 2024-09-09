package com.mikrelin.springbootbackend.dao;

import com.mikrelin.springbootbackend.entity.Trade;
import com.mikrelin.springbootbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TradeRepository extends JpaRepository<Trade, Long> {
    List<Trade> findByUser(User user);
}
