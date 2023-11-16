package com.chanchal.futures.processor.impl;

import com.chanchal.futures.bo.ClientBO;
import com.chanchal.futures.bo.OrderBO;
import com.chanchal.futures.processor.IMessageProcessor;
import com.chanchal.futures.processor.helper.SimpleMapper;
import com.chanchal.futures.to.OrderTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class OrderProcessor implements IMessageProcessor<OrderBO, OrderTO> {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${staticdata.service.url}")
    private String staticServiceUrl;

    @Override
    public OrderBO processMessage(OrderTO orderTO) {
        SimpleMapper instance = SimpleMapper.INSTANCE;
        OrderBO orderBO = instance.OrderTOToOrderBO(orderTO);
        URI uri = UriComponentsBuilder.fromUriString(staticServiceUrl).path("/client")
                .queryParam("code", "mac").build().encode().toUri();
        ClientBO client = restTemplate.getForObject(uri, ClientBO.class);
        if (client != null) {
            orderBO.setBrokerClient(client.getName());
        }
        return orderBO;
    }
}





