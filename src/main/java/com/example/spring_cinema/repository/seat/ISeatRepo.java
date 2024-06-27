package com.example.spring_cinema.repository.seat;

import com.example.spring_cinema.dto.Seat.SeatProjection;
import com.example.spring_cinema.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISeatRepo extends JpaRepository<Seat, Integer> {
    @Query(value = "select s.name as seatName, ts.price as price from Seat s join TypeSeat ts on s.typeSeat.id = ts.id " +
            "where s.ticket.ticketId = :ticketId")
    List<SeatProjection> listSeatProjection(@Param("ticketId") int ticketId);
}
