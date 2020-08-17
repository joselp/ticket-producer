package com.jp.event.ticketproducer.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Ticket {

    private Integer id;
    private LocalDateTime issueDate;
    private String seat;
    private LocalDateTime showDate;

    @JsonIgnore
    public boolean isValidTicket() {

        return showDate.isAfter(LocalDateTime.now());
    }
}