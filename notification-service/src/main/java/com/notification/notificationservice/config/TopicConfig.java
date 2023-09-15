package com.notification.notificationservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.listener.ChannelTopic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class TopicConfig {

    @Value("${redis.customer.topic}")
    private String redisCustomerPubSubTopic;


    @Value("${redis.item.topic}")
    private String redisItemPubSubTopic;


    @Bean
    public List<ChannelTopic> topicMap() {
        List<ChannelTopic> channelTopicList = new ArrayList<>();
        channelTopicList.add(new ChannelTopic(redisCustomerPubSubTopic));
        channelTopicList.add(new ChannelTopic(redisItemPubSubTopic));
        return channelTopicList;
    }
}