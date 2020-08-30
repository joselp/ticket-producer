package com.jp.event.ticketproducer.adapter.in;

import com.jp.event.ticketproducer.application.domain.Ticket;
import com.jp.event.ticketproducer.application.rest.TicketApi;
import com.jp.event.ticketproducer.application.port.in.TicketUseCase;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class TicketController implements TicketApi {

    Logger logger = Logger.getLogger(TicketController.class.getName());

    private TicketUseCase ticketUseCase;

    public TicketController(TicketUseCase ticketUseCase) {
        this.ticketUseCase = ticketUseCase;
    }

    @Override
    public Ticket createTicket(Ticket ticket) {
        logger.info("Getting ticket " + ticket);

        return ticketUseCase.createTicket(ticket);
    }

    @Override
    public boolean updateTicketShowDate(String id, Integer postpone) {
        return ticketUseCase.updateShowDate(id, postpone);
    }
}