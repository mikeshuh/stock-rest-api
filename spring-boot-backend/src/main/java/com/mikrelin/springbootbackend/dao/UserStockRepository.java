package com.mikrelin.springbootbackend.dao;

import com.mikrelin.springbootbackend.entity.User;
import com.mikrelin.springbootbackend.entity.UserStock;
import com.mikrelin.springbootbackend.entity.UserStockId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserStockRepository extends JpaRepository<UserStock, UserStockId> {
    List<UserStock> findByUserStockId_User(User user);
}
