package com.example.spring_cinema.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private int id;
    @Column(columnDefinition = "Date")
    private Date showDate;

    private Time showTime;

    @OneToMany(mappedBy = "schedule")
    @JsonBackReference
    private List<CalendarShow> calendarShows;

    public Schedule() {
    }

    public Schedule(int id, Date showDate, Time showTime, List<CalendarShow> calendarShows) {
        this.id = id;
        this.showDate = showDate;
        this.showTime = showTime;
        this.calendarShows = calendarShows;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getShowDate() {
        return showDate;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }

    public Time getShowTime() {
        return showTime;
    }

    public void setShowTime(Time showTime) {
        this.showTime = showTime;
    }

    public List<CalendarShow> getCalendarShows() {
        return calendarShows;
    }

    public void setCalendarShows(List<CalendarShow> calendarShows) {
        this.calendarShows = calendarShows;
    }
}
