package com.example.spring_cinema.repository.ticket;

import com.example.spring_cinema.dto.Ticket.TicketDetailProjection;
import com.example.spring_cinema.dto.Ticket.TicketProjection;
import com.example.spring_cinema.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ITicketRepo extends JpaRepository<Ticket, Integer> {
    @Query(value = "select t.ticketId as ticketId, c.customerId as customerId," +
            " c.fullName as fullName, c.idCard as idCard, c.phone as phone, " +
            "m.name as name, s.showDate as showDate, s.showTime as showTime from Ticket as t join " +
            "Invoice i on t.invoice.id = i.id join Customer c on " +
            "i.customer.customerId = c.customerId join CalendarShow ca on " +
            "t.calendarShow.id = ca.id join Movie m on ca.movie.id = m.id join " +
            "Schedule s on ca.schedule.id = s.id")
    Page<TicketProjection> findAllTicket(Pageable pageable);

    @Query(value = "select m.name as name, t.ticketId as ticketId, r.name as roomName, s.showDate as showDate, " +
            "s.showTime as showTime, c.customerId as customerId, c.idCard as idCard, c.fullName as fullName, " +
            "c.phone as phone from Ticket t join t.calendarShow ca" +
            " join ca.schedule s" +
            " join ca.room r" +
            " join ca.movie m " +
            "join t.invoice i " +
            "join i.employee e " +
            "join i.customer c " +
            "where t.ticketId = :ticketId")
    TicketDetailProjection TicketById(@Param("ticketId") int ticketId);

}
