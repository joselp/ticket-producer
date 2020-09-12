package com.jp.event.ticketproducer.application.domain.usecase;

import com.jp.event.ticketproducer.application.domain.Ticket;
import com.jp.event.ticketproducer.application.port.in.TicketUseCase;
import com.jp.event.ticketproducer.application.port.out.TicketRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public class TicketUseCaseImpl implements TicketUseCase {

    private TicketRepository ticketRepository;

    public TicketUseCaseImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket createTicket(Ticket ticket) {

        ticket.setId(UUID.randomUUID().toString());
        ticket.setIssueDate(LocalDateTime.now());

        ticketRepository.publish(ticket);

        return ticket;
    }

    @Override
    public Optional<Ticket> getTicket(String id) {

        return ticketRepository.get(id);

    }

    @Override
    public boolean updateShowDate(String id, Integer postpone) {
        return  ticketRepository.updateShowDate(id, postpone) > 0;
    }
}
