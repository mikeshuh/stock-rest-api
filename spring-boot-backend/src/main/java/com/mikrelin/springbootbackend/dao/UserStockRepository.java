package com.mikrelin.springbootbackend.dao;

import com.mikrelin.springbootbackend.entity.UserStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStockRepository extends JpaRepository<UserStock, Integer> {
}
