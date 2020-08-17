package com.jp.event.ticketproducer.adapter.in;

import com.jp.event.ticketproducer.application.port.in.TicketService;
import com.jp.event.ticketproducer.application.rest.TicketApi;
import com.jp.event.ticketproducer.domain.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController implements TicketApi {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Override
    public Ticket createTicket(Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    @Override
    public boolean updateTicketShowDate(Integer id, Integer postpone) {
        return ticketService.updateShowDate(id, postpone);
    }
}