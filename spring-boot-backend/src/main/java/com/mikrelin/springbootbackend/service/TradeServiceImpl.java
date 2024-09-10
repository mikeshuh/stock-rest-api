package com.mikrelin.springbootbackend.service;

import com.mikrelin.springbootbackend.dao.TradeRepository;
import com.mikrelin.springbootbackend.dao.UserRepository;
import com.mikrelin.springbootbackend.dto.TradeDTO;
import com.mikrelin.springbootbackend.dto.UserStockDTO;
import com.mikrelin.springbootbackend.entity.Trade;
import com.mikrelin.springbootbackend.entity.User;
import com.mikrelin.springbootbackend.entity.UserStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TradeServiceImpl implements TradeService {
    private TradeRepository tradeRepository;
    private UserRepository userRepository;

    @Autowired
    public TradeServiceImpl(TradeRepository tradeRepository, UserRepository userRepository) {
        this.tradeRepository = tradeRepository;
        this.userRepository = userRepository;
    }

    // This method handles the conversion from Trade entity to TradeDTO
    private TradeDTO convertToDTO(Trade trade) {
        if (trade == null) {        // temp fix
            return null;
        }
        // Extract the userId and stockId from the Trade entity
        long userId = trade.getUser().getUserId();
        long stockId = trade.getStock().getStockId();

        // Create a new TradeDTO with the extracted fields from the entity
        return new TradeDTO(
                trade.getTradeId(),
                userId,
                stockId,
                trade.getTradeType(),
                trade.getQuantity(),
                trade.getPrice(),
                trade.getTimeExecuted()
        );
    }

    private List<TradeDTO> convertToDTOList(List<Trade> tradeList) {
        return tradeList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TradeDTO> findAll() {
        return convertToDTOList(tradeRepository.findAll());
    }

    @Override
    public TradeDTO findByTradeId(long tradeId) {
        return convertToDTO(tradeRepository.findById(tradeId)
                .orElse(null));      // make sure to update not found logic
    }

    @Override
    public List<TradeDTO> findByUserId(long userId) {
        User user = userRepository.findById(userId)
                .orElse(null);
        return convertToDTOList(tradeRepository.findByUser(user));
    }

    @Override
    public TradeDTO save(Trade trade) {
        return convertToDTO(tradeRepository.save(trade));
    }

    @Override
    public void deleteByTradeId(long tradeId) {
        tradeRepository.deleteById(tradeId);
    }
}
