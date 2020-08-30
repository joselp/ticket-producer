package com.jp.event.ticketproducer.application.port.in;

import com.jp.event.ticketproducer.application.domain.Ticket;

import java.util.Optional;

public interface TicketUseCase {

    Ticket createTicket(Ticket ticket);

    Optional<Ticket> getTicket(String id);

    boolean updateShowDate(String id, Integer postpone);
}
