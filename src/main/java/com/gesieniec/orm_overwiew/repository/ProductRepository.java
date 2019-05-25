package com.gesieniec.orm_overwiew.repository;

import com.gesieniec.orm_overwiew.entity.ProductEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity,Long> {
}
