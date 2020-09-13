package com.jp.event.ticketproducer.adapter.out;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.jp.event.ticketproducer.application.domain.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Repository;

import javax.jms.Queue;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class JMSPublisher {

    private JmsTemplate jmsTemplate;
    private Queue queueCreate;
    private Queue queueUpdate;

    @Autowired
    public JMSPublisher(JmsTemplate jmsTemplate, Queue queueCreate, Queue queueUpdate) {
        this.jmsTemplate = jmsTemplate;
        this.queueCreate = queueCreate;
        this.queueUpdate = queueUpdate;
    }

    Ticket publish(Ticket ticket)  {

        String ticketString = null;
        try {
            ticketString = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(ticket);
            System.out.println(ticketString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        jmsTemplate.convertAndSend(queueCreate, ticketString);
        return ticket;
    }

    Optional<Ticket> get(String id) {
        return Optional.empty();
    }

    int updateShowDate(String id, Integer days) {

        Map<String, Integer> update = new HashMap<>();
        update.put(id, days);

        jmsTemplate.convertAndSend(queueUpdate, update);
        return 1;
    }
}
