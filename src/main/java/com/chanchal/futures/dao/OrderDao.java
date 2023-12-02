package com.chanchal.futures.dao;

import com.chanchal.futures.bo.OrderBO;
import com.chanchal.futures.processor.impl.OrderProcessor;
import com.chanchal.futures.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderDao {
    private final Logger logger = LoggerFactory.getLogger(OrderDao.class);

    @Autowired
    private OrderRepository repository;

    @CacheEvict(cacheNames = "orders", key = "#orderBO.requestId")
    public OrderBO persistData(OrderBO orderBO) {
        OrderBO savedOrder = repository.save(orderBO);
        logger.info("savedOrder::{}", savedOrder);
        return savedOrder;
    }

    @Cacheable(cacheNames = "orders", key = "requestId")
    public Optional<OrderBO> getData(Long requestId) {
        logger.info("fetching orders from db");
        return repository.findById(requestId);
    }


}
