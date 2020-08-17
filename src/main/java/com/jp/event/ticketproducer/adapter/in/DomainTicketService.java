package com.jp.event.ticketproducer.adapter.in;

import com.jp.event.ticketproducer.application.entity.TicketEntity;
import com.jp.event.ticketproducer.application.port.in.TicketService;
import com.jp.event.ticketproducer.application.port.out.TicketRepository;
import com.jp.event.ticketproducer.domain.Ticket;

import java.time.LocalDateTime;
import java.util.Optional;

public class DomainTicketService implements TicketService {

    private TicketRepository ticketRepository;

    public DomainTicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket createTicket(Ticket ticket) {

        TicketEntity entity = ticketRepository.save(TicketEntity.builder()
                .seat(ticket.getSeat())
                .issueDate(LocalDateTime.now())
                .showDate(ticket.getShowDate())
                .build());
        ticket.setId(entity.getId());

        return ticket;
    }

    @Override
    public Optional<Ticket> getTicket(Integer id) {

        Optional<TicketEntity> ticketEntity = ticketRepository.get(id);

        return ticketEntity.map(entity -> Ticket.builder()
                .id(id)
                .issueDate(entity.getIssueDate())
                .seat(entity.getSeat())
                .showDate(entity.getShowDate())
                .build());
    }

    @Override
    public boolean updateShowDate(Integer id, Integer postpone) {
        return  ticketRepository.updateShowDate(id, LocalDateTime.now().plusDays(postpone)) > 0;
    }
}
