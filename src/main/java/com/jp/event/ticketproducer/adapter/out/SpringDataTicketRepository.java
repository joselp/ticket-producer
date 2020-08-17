package com.jp.event.ticketproducer.adapter.out;

import com.jp.event.ticketproducer.application.entity.TicketEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface SpringDataTicketRepository extends CrudRepository<TicketEntity, Integer> {

    @Modifying
    @Query("update TicketEntity t set t.showDate = ?2 where t.id = ?1")
    int updateShowDate(Integer id, LocalDateTime showDate);

}