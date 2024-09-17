package com.mikrelin.springbootbackend.rest;

import com.mikrelin.springbootbackend.dto.UserStockDTO;
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
    public List<UserStockDTO> findAllUserStock() {
        return userStockService.findAll();
    }

    @GetMapping("/{userId}")
    public List<UserStockDTO> findByUserId(@PathVariable long userId) {
        return userStockService.findByUserId(userId);
    }

    @GetMapping("/{userId}/{stockId}")
    public UserStockDTO findByUserStockId(@PathVariable long userId, @PathVariable long stockId) {
        return userStockService.findByUserIdAndStockId(userId, stockId);
    }

    @PostMapping
    public UserStockDTO addUserStock(@RequestBody UserStockDTO userStockDTO) {
        return userStockService.save(userStockDTO);
    }

    @PutMapping
    public UserStockDTO updateUserStock(@RequestBody UserStockDTO userStockDTO) {
        return userStockService.save(userStockDTO);
    }

    @DeleteMapping("/{userId}/{stockId}")
    public void deleteUserStock(@PathVariable long userId, @PathVariable long stockId) {
        userStockService.deleteByUserIdAndStockId(userId, stockId);
    }
}
