package com.jp.event.ticketproducer.adapter.configuration;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

@EnableJms
@Configuration
public class JMSConfig {

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("simpleJms.queue");
    }
}