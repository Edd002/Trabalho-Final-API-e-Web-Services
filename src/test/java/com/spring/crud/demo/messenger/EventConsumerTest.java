package com.spring.crud.demo.messenger;

import com.spring.crud.demo.config.EventMessageConfig;
import com.spring.crud.demo.dto.EventDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EventConsumerTest {

    private static final String EVENT_NAME = "Interval";
    private static final int MATCH_ID = 2;

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Test
    public void produceMessage() {
        EventDTO eventDTO = new EventDTO(EVENT_NAME, MATCH_ID);
        rabbitTemplate.convertAndSend(EventMessageConfig.NAME_EXCHANGE, EventMessageConfig.ROUTING_KEY, eventDTO);
    }
}