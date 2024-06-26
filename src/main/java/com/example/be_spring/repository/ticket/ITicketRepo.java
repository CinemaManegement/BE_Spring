package com.example.be_spring.repository.ticket;

import com.example.be_spring.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITicketRepo extends JpaRepository<Ticket, Integer> {
}
