package com.gesieniec.orm_overwiew.service;

import com.gesieniec.orm_overwiew.dto.OrderDao;
import com.gesieniec.orm_overwiew.dto.OrdersDto;
import com.gesieniec.orm_overwiew.dto.ProductDto;
import com.gesieniec.orm_overwiew.entity.OrdersEntity;
import com.gesieniec.orm_overwiew.entity.ProductEntity;
import com.gesieniec.orm_overwiew.entity.UserEntity;
import com.gesieniec.orm_overwiew.repository.OrdersRepository;
import com.gesieniec.orm_overwiew.repository.ProductRepository;
import com.gesieniec.orm_overwiew.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrdersService {

    private OrdersRepository ordersRepository;
    private UserRepository userRepository;
    private ProductRepository productRepository;

    public OrdersService(OrdersRepository ordersRepository,
                         UserRepository userService,
                         ProductRepository productService) {
        this.ordersRepository = ordersRepository;
        this.userRepository = userService;
        this.productRepository = productService;
    }

    public List<OrdersDto> getAllOrders() {
        return ordersRepository
                .findAll()
                .stream()
                .map(OrdersEntity::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void addOrder(OrderDao ordersDto) {

        final UserEntity userByEmail = userRepository.getUserByEmail(ordersDto.getUserEmail());
        final List<ProductEntity> productsByNames = productRepository.findAllByIdIn(ordersDto.getProductIds());

        ordersRepository.save(new OrdersEntity(userByEmail, productsByNames));
    }

    public void deleteOrder(String orderId) {
        final OrdersEntity byOrderId = ordersRepository.findByOrderId(orderId);
        ordersRepository.delete(byOrderId);
    }
}
