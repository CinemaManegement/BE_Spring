package com.example.spring_cinema.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class CalendarShow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "calendar_show_id")
    private int id;

    private String detail;

    @ManyToOne
    @JoinColumn(name = "schedule_id",referencedColumnName = "schedule_id")
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "room_id",referencedColumnName = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "movie_id",referencedColumnName = "movie_id")
    private Movie movie;

    @OneToMany(mappedBy = "calendarShow")
    @JsonBackReference
    private List<Ticket> tickets;

    public CalendarShow() {
    }


}
