package com.gesieniec.orm_overwiew.repository;

import com.gesieniec.orm_overwiew.entity.OrdersEntity;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends CrudRepository<OrdersEntity, Long> {

    List<OrdersEntity> findAll();
}
