package com.example.spring_cinema.service.ticket;

import com.example.spring_cinema.dto.Ticket.TicketDetailProjection;
import com.example.spring_cinema.dto.Ticket.TicketProjection;
import com.example.spring_cinema.model.Ticket;
import com.example.spring_cinema.repository.ticket.ITicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TicketService implements ITicketService{
    @Autowired
    ITicketRepo iTicketRepo;

    @Override
    public Page<TicketProjection> findAllTicket(Pageable pageable) {
        return iTicketRepo.findAllTicket(pageable);
    }

    @Override
    public TicketDetailProjection getTicketByTicketId(int id) {
        return iTicketRepo.TicketById(id);
    }
}
