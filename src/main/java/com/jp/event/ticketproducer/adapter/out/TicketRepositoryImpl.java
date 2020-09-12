package com.jp.event.ticketproducer.adapter.out;

import com.jp.event.ticketproducer.application.domain.Ticket;
import com.jp.event.ticketproducer.application.port.out.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@Primary
public class TicketRepositoryImpl implements TicketRepository {

    private JMSPublisher jmsPublisher;

    @Autowired
    public TicketRepositoryImpl(JMSPublisher jmsPublisher) {
        this.jmsPublisher = jmsPublisher;
    }

    @Override
    public Ticket publish(Ticket ticket) {
        return jmsPublisher.publish(ticket);
    }

    @Override
    public Optional<Ticket> get(String id) {
        return jmsPublisher.get(id);
    }

    @Override
    public int updateShowDate(String id, Integer postpone) {
        return jmsPublisher.updateShowDate(id, postpone);
    }
}
