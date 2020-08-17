package com.jp.event.ticketproducer.application.port.in;

import com.jp.event.ticketproducer.domain.Ticket;

import java.util.Optional;

public interface TicketService {

    Ticket createTicket(Ticket ticket);

    Optional<Ticket> getTicket(Integer id);

    boolean updateShowDate(Integer id, Integer postpone);
}
