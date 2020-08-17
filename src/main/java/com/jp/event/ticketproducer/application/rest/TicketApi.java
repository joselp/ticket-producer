package com.jp.event.ticketproducer.application.rest;

import com.jp.event.ticketproducer.domain.Ticket;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public interface TicketApi {

    @PostMapping("/tickets")
    Ticket createTicket(Ticket ticket);

    @PutMapping("/tickets/{postpone}")
    boolean updateTicketShowDate(Integer id, @PathVariable(name = "postpone") Integer postpone);
}
