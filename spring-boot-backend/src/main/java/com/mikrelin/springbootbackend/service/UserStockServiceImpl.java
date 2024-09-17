package com.mikrelin.springbootbackend.service;

import com.mikrelin.springbootbackend.dao.StockRepository;
import com.mikrelin.springbootbackend.dao.UserRepository;
import com.mikrelin.springbootbackend.dao.UserStockRepository;
import com.mikrelin.springbootbackend.dto.UserStockDTO;
import com.mikrelin.springbootbackend.entity.Stock;
import com.mikrelin.springbootbackend.entity.User;
import com.mikrelin.springbootbackend.entity.UserStock;
import com.mikrelin.springbootbackend.entity.UserStockId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserStockServiceImpl implements UserStockService {
    private UserStockRepository userStockRepository;
    private UserRepository userRepository;
    private StockRepository stockRepository;

    @Autowired
    public UserStockServiceImpl(UserStockRepository userStockRepository, UserRepository userRepository, StockRepository stockRepository) {
        this.userStockRepository = userStockRepository;
        this.userRepository = userRepository;
        this.stockRepository = stockRepository;
    }

    // This method handles the conversion from entity to DTO
    private UserStockDTO convertToDTO(UserStock userStock) {
        if (userStock == null) {        // temp fix
            return null;
        }
        // Extract the userId and stockId from the embedded UserStockId object in the UserStock entity
        long userId = userStock.getUserStockId().getUser().getUserId();
        long stockId = userStock.getUserStockId().getStock().getStockId();

        // Create a new UserStockDTO with the extracted fields from the entity
        return new UserStockDTO(
                userId,
                stockId,
                userStock.getAllocatedAmount(),
                userStock.getQuantity(),
                userStock.getPrice(),
                userStock.getLastUpdated()
        );
    }

    private List<UserStockDTO> convertToDTOList(List<UserStock> userStockList) {
        return userStockList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private UserStock convertToUserStock(UserStockDTO userStockDTO) {
        UserStock userStock = new UserStock();
        // Fetch the User and Stock entities based on their IDs in the DTO
        // Assuming you have some service/repository method to retrieve these entities by their IDs.
        User user = userRepository.findById(userStockDTO.getUserId())  // Fetch the user based on userId
                .orElse(null);      // temp fix
        Stock stock = stockRepository.findById(userStockDTO.getStockId()) // Fetch the stock based on stockId
            .orElse(null);      // tempfix

        // Set the userStockId by using the fetched user and stock
        UserStockId userStockId = new UserStockId(user, stock);
        userStock.setUserStockId(userStockId);

        // Set the other fields from the DTO
        userStock.setAllocatedAmount(userStockDTO.getAllocatedAmount());
        userStock.setQuantity(userStockDTO.getQuantity());
        userStock.setPrice(userStockDTO.getPrice());
        userStock.setLastUpdated(userStockDTO.getLastUpdated());

        return userStock;
    }


    @Override
    public List<UserStockDTO> findAll() {
        return convertToDTOList(userStockRepository.findAll());
    }

    @Override
    public List<UserStockDTO> findByUserId(long userId) {
        User user = userRepository.findById(userId)
                .orElse(null);
        return convertToDTOList(userStockRepository.findByUserStockId_User(user));
    }

    @Override
    public UserStockDTO findByUserIdAndStockId(long userId, long stockId) {
        User user = userRepository.findById(userId)
                .orElse(null);
        Stock stock = stockRepository.findById(stockId)
                .orElse(null);
        return convertToDTO(userStockRepository.findById(new UserStockId(user, stock))
                .orElse(null));      // make sure to update not found logic
    }

    @Override
    public UserStockDTO save(UserStockDTO userStockDTO) {
        UserStock userStock = convertToUserStock(userStockDTO);
        return convertToDTO(userStockRepository.save(userStock));
    }

    @Override
    public void deleteByUserIdAndStockId(long userId, long stockId) {
        User user = userRepository.findById(userId)
                .orElse(null);
        Stock stock = stockRepository.findById(stockId)
                .orElse(null);
        userStockRepository.deleteById(new UserStockId(user, stock));
    }
}
