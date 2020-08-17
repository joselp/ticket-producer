package com.jp.event.ticketproducer.adapter.out;

import com.jp.event.ticketproducer.application.entity.TicketEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Repository;

import javax.jms.Queue;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public class JMSPublisher {

    private JmsTemplate jmsTemplate;
    private Queue queue;

    @Autowired
    public JMSPublisher(JmsTemplate jmsTemplate, Queue queue) {
        this.jmsTemplate = jmsTemplate;
        this.queue = queue;
    }

    public TicketEntity save(TicketEntity ticketEntity) {
        jmsTemplate.convertAndSend(queue, ticketEntity);
        return ticketEntity;
    }

    public Optional<TicketEntity> get(Integer id) {
        return Optional.empty();
    }

    public int updateShowDate(Integer id, LocalDateTime newDate) {
        TicketEntity ticketEntity = TicketEntity.builder()
                .id(id)
                .showDate(newDate)
                .build();
        jmsTemplate.convertAndSend(queue, ticketEntity);
        return 1;
    }
}
