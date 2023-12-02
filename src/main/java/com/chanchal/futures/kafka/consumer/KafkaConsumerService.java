package com.chanchal.futures.kafka.consumer;

import com.chanchal.futures.bo.ApplicationErrorBO;
import com.chanchal.futures.bo.OrderBO;
import com.chanchal.futures.dao.OrderDao;
import com.chanchal.futures.processor.impl.OrderProcessor;
import com.chanchal.futures.repository.ApplicationErrorRepository;
import com.chanchal.futures.to.OrderTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class KafkaConsumerService {
    private final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ApplicationErrorRepository errorRepository;

    @Autowired
    private OrderProcessor transformer;

    @KafkaListener(topics = "order-topic", groupId = "group-1")
    public void receiveMessageFromFirstExchange(String message, @Header(KafkaHeaders.OFFSET) Long offset, @Header(KafkaHeaders.RECEIVED_KEY) String key) {
        logger.info("received message with offset:{} and key: {}. Message:: {}", offset, key, message);
        try {
            OrderTO orderTO = objectMapper.readValue(message, OrderTO.class);
            OrderBO orderBO = transformer.processMessage(orderTO);
            OrderBO savedOrderBO = orderDao.persistData(orderBO);
            logger.info("transformed and persisted order message for reporting");
        } catch (Exception e) {
            logger.error("Exception occurred while consuming message from order topic. Key:{}, message:{}", key, message);
            ApplicationErrorBO applicationErrorBO = ApplicationErrorBO.builder().messageType(key).source("First-Exchange").message(message).error(Arrays.toString(e.getStackTrace())).build();
            errorRepository.save(applicationErrorBO);
        }
    }
}
