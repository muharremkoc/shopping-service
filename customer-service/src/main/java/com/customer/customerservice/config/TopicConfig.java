package com.customer.customerservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.listener.ChannelTopic;

@Configuration
public class TopicConfig {

    @Value("${redis.customer.topic}")
    private String redisPubSubTopic;

    @Bean
    public ChannelTopic topic() {
        return new ChannelTopic(redisPubSubTopic);
    }

}