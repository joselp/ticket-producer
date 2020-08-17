package com.jp.event.ticketproducer.application.port.out;

import com.jp.event.ticketproducer.application.entity.TicketEntity;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TicketRepository {

    TicketEntity save(TicketEntity ticketEntity);

    Optional<TicketEntity> get(Integer id);

    int updateShowDate(Integer id, LocalDateTime newDate);
}