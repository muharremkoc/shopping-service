package com.customer.customerservice.service.publisher;

import com.customer.customerservice.domain.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
public class CustomerPublisherServiceImpl implements CustomerPublisherService{

    Logger log =  LoggerFactory.getLogger(CustomerPublisherServiceImpl.class);

    private final RedisTemplate<String,Object> redisTemplate;

    private final ChannelTopic channelTopic;

    public CustomerPublisherServiceImpl(RedisTemplate<String, Object> redisTemplate, ChannelTopic channelTopic) {
        this.redisTemplate = redisTemplate;
        this.channelTopic = channelTopic;
    }

    @Override
    public Long publish(Customer customer) {
        log.info(String.format("Sending Message: %s",customer.toString()));
        return redisTemplate.convertAndSend(channelTopic.getTopic(), customer);
    }
}
