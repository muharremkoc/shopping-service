package com.notification.notificationservice.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.notification.notificationservice.model.Customer;
import com.notification.notificationservice.model.Item;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ItemEventListener implements MessageListener {
    private final ObjectMapper objectMapper;

    private final RedisTemplate<String,Object> redisTemplate;

    public ItemEventListener(ObjectMapper objectMapper, RedisTemplate<String, Object> redisTemplate) {
        this.objectMapper = objectMapper;
        this.redisTemplate = redisTemplate;
    }


    @Override
    public void onMessage(@NonNull Message message, byte[] pattern) {
        log.info("new message received for Item");
        try {
            Item item = objectMapper.readValue(message.getBody(), Item.class);
            redisTemplate.opsForValue().set(String.valueOf(item.getId()),item);
            log.info(String.format( "New Item  create operations is success: %s",
                    item));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
