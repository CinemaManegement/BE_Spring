package com.example.spring_cinema.service.ticket;

import com.example.spring_cinema.dto.Ticket.TicketDetailProjection;
import com.example.spring_cinema.dto.Ticket.TicketProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITicketService {
    Page<TicketProjection> findAllTicket(Pageable pageable);
    TicketDetailProjection getTicketByTicketId(int id);
}
