package com.example.spring_cinema.dto.Ticket;

import java.sql.Time;
import java.util.Date;

public interface TicketDetailProjection {
    String getName();
    Integer getTicketId();
    String getRoomName();
    Date getShowDate();
    Time getShowTime();
    Integer getCustomerId();
    String getIdCard();
    String getFullName();
    String getPhone();
}
