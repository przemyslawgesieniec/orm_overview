package com.gesieniec.orm_overwiew.service;

import com.gesieniec.orm_overwiew.dto.OrdersDto;
import com.gesieniec.orm_overwiew.entity.OrdersEntity;
import com.gesieniec.orm_overwiew.repository.OrdersRepository;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class OrdersService {

    private OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public List<OrdersDto> getAllOrders() {
        return ordersRepository
                .findAll()
                .stream()
                .map(OrdersEntity::toDto)
                .collect(Collectors.toList());
    }
}
