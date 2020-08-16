package com.jp.event.ticketproducer.application.port.in;

import com.jp.event.ticketproducer.domain.Ticket;

import java.time.LocalDateTime;

public interface TicketService {

    Ticket createTicket(Ticket ticket);

    Ticket getTicket();

    Ticket updateShowDate(String id, LocalDateTime newDate);
}
