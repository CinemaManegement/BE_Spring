package com.example.spring_cinema.model;

import jakarta.persistence.*;

@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private int id;

    private String name;

    private Boolean checkSeat;

    @ManyToOne
    @JoinColumn(name = "type_seat_id",referencedColumnName = "type_seat_id")
    private TypeSeat typeSeat;

    @ManyToOne
    @JoinColumn(name = "room_id",referencedColumnName = "room_id")
    private Room room;

    public Seat() {
    }

    public Seat(int id, String name, Boolean checkSeat, TypeSeat typeSeat, Room room) {
        this.id = id;
        this.name = name;
        this.checkSeat = checkSeat;
        this.typeSeat = typeSeat;
        this.room = room;
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

    public Boolean getCheckSeat() {
        return checkSeat;
    }

    public void setCheckSeat(Boolean checkSeat) {
        this.checkSeat = checkSeat;
    }

    public TypeSeat getTypeSeat() {
        return typeSeat;
    }

    public void setTypeSeat(TypeSeat typeSeat) {
        this.typeSeat = typeSeat;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
