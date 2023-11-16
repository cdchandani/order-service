package com.chanchal.futures.dao;

import com.chanchal.futures.bo.OrderBO;
import com.chanchal.futures.processor.impl.OrderProcessor;
import com.chanchal.futures.repository.OrderRepository;
import com.chanchal.futures.to.OrderTO;
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
    private OrderProcessor transformer;
    @Autowired
    private OrderRepository repository;

    @CacheEvict(cacheNames = "orderTO",  key = "#orderTO.requestId")
    public OrderBO persistData(OrderTO orderTO) {
        OrderBO daywiseOrderBO = transformer.processMessage(orderTO);
        OrderBO savedOrder = repository.save(daywiseOrderBO);
        logger.info("savedOrder::{}", savedOrder);
        return savedOrder;
    }

    @Cacheable(cacheNames = "orderBO", key = "requestId")
    public Optional<OrderBO> getData(Long requestId) {
        return repository.findById(requestId);
    }


}
