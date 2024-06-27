package com.example.spring_cinema.service.seat;

import com.example.spring_cinema.dto.Seat.SeatProjection;

import java.util.List;

public interface ISeatService {
    List<SeatProjection> listSeatProjection(int ticketId);
}
