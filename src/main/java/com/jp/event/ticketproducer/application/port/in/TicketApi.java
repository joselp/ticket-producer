package com.jp.event.ticketproducer.application.port.in;

import com.jp.event.ticketproducer.application.domain.Ticket;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface TicketApi {

    @PostMapping("/tickets")
    Ticket createTicket(@RequestBody Ticket ticket);

    @PutMapping("/tickets/{postpone}")
    boolean updateTicketShowDate(String id, @PathVariable(name = "postpone") Integer postpone);
}
