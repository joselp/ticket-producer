package com.jp.event.ticketproducer.adapter.configuration;

import com.jp.event.ticketproducer.TicketProducerApplication;
import com.jp.event.ticketproducer.application.domain.usecase.TicketUseCaseImpl;
import com.jp.event.ticketproducer.application.port.in.TicketUseCase;
import com.jp.event.ticketproducer.application.port.out.TicketRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = TicketProducerApplication.class)
public class BeanConfiguration {

    @Bean
    TicketUseCase ticketUseCase(TicketRepository ticketRepository){
        return new TicketUseCaseImpl(ticketRepository);
    }
}