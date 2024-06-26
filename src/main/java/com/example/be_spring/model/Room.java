package com.example.be_spring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private int id;

    private String name;

    private String roomDetail;

    @OneToMany(mappedBy = "room")
    @JsonBackReference
    private List<Seat> seatList;

    @OneToMany(mappedBy = "room")
    @JsonBackReference
    private List<CalendarShow> calendarShows;

    public Room() {
    }

    public Room(int id, String name, String roomDetail, List<Seat> seatList, List<CalendarShow> calendarShows) {
        this.id = id;
        this.name = name;
        this.roomDetail = roomDetail;
        this.seatList = seatList;
        this.calendarShows = calendarShows;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomDetail() {
        return roomDetail;
    }

    public void setRoomDetail(String roomDetail) {
        this.roomDetail = roomDetail;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }

    public List<CalendarShow> getCalendarShows() {
        return calendarShows;
    }

    public void setCalendarShows(List<CalendarShow> calendarShows) {
        this.calendarShows = calendarShows;
    }
}
