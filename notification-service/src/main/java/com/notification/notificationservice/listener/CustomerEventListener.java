package com.notification.notificationservice.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.notification.notificationservice.model.Customer;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerEventListener implements MessageListener {

    private final ObjectMapper objectMapper;

    private final RedisTemplate<String,Object> redisTemplate;

    public CustomerEventListener(ObjectMapper objectMapper, RedisTemplate<String, Object> redisTemplate) {
        this.objectMapper = objectMapper;
        this.redisTemplate = redisTemplate;
    }


    @Override
    public void onMessage(@NonNull Message message, byte[] pattern) {
        log.info("new message received for Customer");
        try {
            Customer customer = objectMapper.readValue(message.getBody(), Customer.class);
            redisTemplate.opsForValue().set(String.valueOf(customer.getId()),customer);
         log.info(String.format( "New Customer  create operations is success: %s",
                 customer));
        } catch (Exception e) {
          log.error(e.getMessage());
        }
    }
}
