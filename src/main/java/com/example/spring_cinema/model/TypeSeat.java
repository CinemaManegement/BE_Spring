package com.example.spring_cinema.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class TypeSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_seat_id")
    private int id;

    private String name;

    private Double price;

    @OneToMany(mappedBy = "typeSeat")
    @JsonBackReference
    private List<Seat> seatList;

    public TypeSeat() {
    }

    public TypeSeat(int id, String name, Double price, List<Seat> seatList) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.seatList = seatList;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }
}
