package com.jp.event.ticketproducer.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
public class Ticket {

    private String Id;
    private LocalDateTime issueDate;
    private String seat;
    private LocalDateTime showDate;

    public boolean isValidTicket() {

        return showDate.isAfter(LocalDateTime.now());
    }
}