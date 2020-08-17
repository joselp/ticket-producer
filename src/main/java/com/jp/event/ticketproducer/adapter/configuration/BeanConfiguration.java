package com.jp.event.ticketproducer.adapter.configuration;

import com.jp.event.ticketproducer.TicketProducerApplication;
import com.jp.event.ticketproducer.adapter.in.DomainTicketService;
import com.jp.event.ticketproducer.application.port.in.TicketService;
import com.jp.event.ticketproducer.application.port.out.TicketRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = TicketProducerApplication.class)
public class BeanConfiguration {

    @Bean
    TicketService ticketService(TicketRepository ticketRepository){
        return new DomainTicketService(ticketRepository);
    }
}