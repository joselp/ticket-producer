package com.jp.event.ticketproducer.adapter.out;

import com.jp.event.ticketproducer.application.entity.TicketEntity;
import com.jp.event.ticketproducer.application.port.out.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@Primary
public class DomainTicketRepository implements TicketRepository {

    private JMSPublisher jmsPublisher;

    @Autowired
    public DomainTicketRepository(JMSPublisher jmsPublisher) {
        this.jmsPublisher = jmsPublisher;
    }

    @Override
    public TicketEntity save(TicketEntity ticketEntity) {
        return jmsPublisher.save(ticketEntity);
    }

    @Override
    public Optional<TicketEntity> get(Integer id) {
        return jmsPublisher.get(id);
    }

    @Override
    public int updateShowDate(Integer id, LocalDateTime newDate) {
        return jmsPublisher.updateShowDate(id, newDate);
    }
}
