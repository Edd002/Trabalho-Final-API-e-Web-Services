package com.spring.crud.demo.messenger;

import com.spring.crud.demo.config.EventMessageConfig;
import com.spring.crud.demo.dto.EventDTO;
import com.spring.crud.demo.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EventConsumer {

    @Autowired
    private EventService service;

    @RabbitListener(bindings = @QueueBinding(value = @Queue(EventMessageConfig.NAME_QUEUE),
            exchange = @Exchange(value = EventMessageConfig.NAME_EXCHANGE),
            key = EventMessageConfig.ROUTING_KEY))
    public void processMessage(final Message message, final EventDTO eventDTO) {
        log.info("Priority ", message.getMessageProperties().getPriority());
        log.info("Consuming and saving EVENT ", eventDTO.getName());
        service.save(eventDTO);
    }
}