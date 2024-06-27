package com.example.spring_cinema.controller;

import com.example.spring_cinema.dto.Ticket.TicketDetailProjection;
import com.example.spring_cinema.dto.Ticket.TicketProjection;
import com.example.spring_cinema.model.Ticket;
import com.example.spring_cinema.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/ticket")
public class TicketController {
    @Autowired
    ITicketService iTicketService;
    @GetMapping("")
    public ResponseEntity<Page<TicketProjection>> findAllTicketProjection() {
        Pageable pageable = PageRequest.of(0,5);
        Page<TicketProjection> ticketProjections = iTicketService.findAllTicket(pageable);
        if(ticketProjections.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticketProjections, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<TicketDetailProjection> findTicketById(@PathVariable int id) {
        TicketDetailProjection ticket = iTicketService.getTicketByTicketId(id);
        if(ticket == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ticket,HttpStatus.OK);
    }
}
