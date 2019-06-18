package com.gesieniec.orm_overwiew.repository;

import com.gesieniec.orm_overwiew.entity.ProductEntity;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity,Long> {

    List<ProductEntity> findAll();
    List<ProductEntity> findAllByIdIn(List<Long> productIds);
}
