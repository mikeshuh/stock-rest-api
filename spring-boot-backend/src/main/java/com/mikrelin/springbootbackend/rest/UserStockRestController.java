package com.mikrelin.springbootbackend.rest;

import com.mikrelin.springbootbackend.entity.UserStock;
import com.mikrelin.springbootbackend.service.UserStockService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userStock")
public class UserStockRestController {
    private UserStockService userStockService;

    public UserStockRestController(UserStockService userStockService) {
        this.userStockService = userStockService;
    }

    @GetMapping
    public List<UserStock> findAllUserStock() {
        return userStockService.findAll();
    }

    @GetMapping("/{userId}")
    public List<UserStock> findByUserId(@PathVariable long userId) {
        return userStockService.findByUserId(userId);
    }

    @GetMapping("/{userId}/{stockId}")
    public UserStock findByUserStockId(@PathVariable long userId, @PathVariable long stockId) {
        return userStockService.findByUserIdAndStockId(userId, stockId);
    }

    @PostMapping
    public UserStock addUserStock(@RequestBody UserStock userStock) {
        return userStockService.save(userStock);
    }

    @PutMapping
    public UserStock updateUserStock(@RequestBody UserStock userStock) {
        return userStockService.save(userStock);
    }

    @DeleteMapping("/{userId}/{stockId}")
    public void deleteUserStock(@PathVariable long userId, @PathVariable long stockId) {
        userStockService.deleteByUserIdAndStockId(userId, stockId);
    }
}
