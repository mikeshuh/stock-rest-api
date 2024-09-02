package com.mikrelin.spring_boot_backend.dao;

import com.mikrelin.spring_boot_backend.entity.UserStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStockRepository extends JpaRepository<UserStock, Integer> {
}
