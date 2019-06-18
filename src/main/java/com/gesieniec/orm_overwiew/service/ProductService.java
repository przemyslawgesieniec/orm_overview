package com.gesieniec.orm_overwiew.service;

import com.gesieniec.orm_overwiew.dto.ProductDto;
import com.gesieniec.orm_overwiew.entity.ProductEntity;
import com.gesieniec.orm_overwiew.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getAllProducts(){
        final List<ProductEntity> productEntities = productRepository.findAll();
        return productEntities.stream().map(ProductEntity::toDto).collect(Collectors.toList());
    }


}
