package com.jp.event.ticketproducer.application.port.out;

import com.jp.event.ticketproducer.application.entity.TicketEntity;

import java.time.LocalDateTime;

public interface TicketRepository {

    TicketEntity save(TicketEntity ticketEntity);

    TicketEntity get(String id);

    TicketEntity updateShowDate(String id, LocalDateTime newDate);
}