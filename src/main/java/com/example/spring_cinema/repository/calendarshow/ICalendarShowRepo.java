package com.example.spring_cinema.repository.calendarshow;

import com.example.spring_cinema.model.CalendarShow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICalendarShowRepo extends JpaRepository<CalendarShow,Integer> {
}
