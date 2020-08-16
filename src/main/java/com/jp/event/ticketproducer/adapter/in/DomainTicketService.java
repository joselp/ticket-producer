package com.jp.event.ticketproducer.adapter.in;

import com.jp.event.ticketproducer.application.entity.TicketEntity;
import com.jp.event.ticketproducer.application.port.in.TicketService;
import com.jp.event.ticketproducer.application.port.out.TicketRepository;
import com.jp.event.ticketproducer.domain.Ticket;

import java.time.LocalDateTime;

public class DomainTicketService implements TicketService {

    private TicketRepository ticketRepository;

    public DomainTicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket createTicket(Ticket ticket) {

        ticketRepository.save(TicketEntity.builder()
                .seat(ticket.getSeat())
                .issueDate(ticket.getIssueDate())
                .showDate(ticket.getShowDate())
                .build());

        return null;
    }

    @Override
    public Ticket getTicket() {
        return null;
    }

    @Override
    public Ticket updateShowDate(String id, LocalDateTime newDate) {
        return null;
    }
}
