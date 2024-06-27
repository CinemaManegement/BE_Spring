package com.example.spring_cinema.service.seat;

import com.example.spring_cinema.dto.Seat.SeatProjection;
import com.example.spring_cinema.repository.seat.ISeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService implements ISeatService{
    @Autowired
    ISeatRepo iSeatRepo;

    @Override
    public List<SeatProjection> listSeatProjection(int ticketId) {
        return iSeatRepo.listSeatProjection(ticketId);
    }
}
