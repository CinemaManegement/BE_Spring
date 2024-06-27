package com.example.spring_cinema.dto;

import java.sql.Time;
import java.util.Date;

public interface TicketProjection {
    Integer getTicketId();
    Integer getCustomerId();
    String getFullName();
    String getIdCard();
    String getPhone();
    String getName();
    Date getShowDate();
    Time getShowTime();
}
