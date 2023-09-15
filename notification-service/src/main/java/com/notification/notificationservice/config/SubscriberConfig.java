package com.notification.notificationservice.config;


import com.notification.notificationservice.listener.CustomerEventListener;
import com.notification.notificationservice.listener.ItemEventListener;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.List;

@Configuration
@AllArgsConstructor
public class SubscriberConfig {


    private final CustomerEventListener customerEventListener;
    private  final ItemEventListener itemEventListener;


    private final LettuceConnectionFactory connectionFactory;

    @Bean
    public MessageListenerAdapter messageListenerAdapter() {
        return new MessageListenerAdapter(customerEventListener);
    }

    @Bean
    public MessageListenerAdapter messageListenerAdapterTwo() {
        return new MessageListenerAdapter(itemEventListener);
    }
    @Bean
    public RedisMessageListenerContainer redisContainer(List<ChannelTopic> topic) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(customerEventListener, topic.get(0));
        container.addMessageListener(itemEventListener,topic.get(1));
        return container;
    }
}
