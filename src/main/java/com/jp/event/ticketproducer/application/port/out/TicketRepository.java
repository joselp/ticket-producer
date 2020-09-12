package com.jp.event.ticketproducer.application.port.out;

import com.jp.event.ticketproducer.application.domain.Ticket;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TicketRepository {

    Ticket publish(Ticket ticket);

    Optional<Ticket> get(String id);

    int updateShowDate(String id, Integer postpone);
}