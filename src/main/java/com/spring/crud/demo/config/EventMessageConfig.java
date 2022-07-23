package com.spring.crud.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventMessageConfig {

    public static final String NAME_QUEUE = "QueueEvent";
    public static final String NAME_EXCHANGE = "ExchangeEvent";
    public static final String ROUTING_KEY = "createEvent";

    @Bean
    DirectExchange eventExchange() {
        return new DirectExchange(NAME_EXCHANGE);
    }

    @Bean
    Queue queue() {
        return QueueBuilder.durable(NAME_QUEUE).build();
    }

    @Bean
    Binding binding() {
        return BindingBuilder.bind(queue()).to(eventExchange()).with(ROUTING_KEY);
    }
}