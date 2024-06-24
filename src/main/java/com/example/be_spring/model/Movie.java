package com.example.spring_cinema.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int id;

    private String name;

    private Date startDay;

    private Date endDay;

    private String actor;

    private String manufacturer;

    private String director;

    private int duration;

    private String trailer;

    private String image;

    private String detail;

    private Boolean status;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "employee_movie",joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> employees;

    @OneToMany(mappedBy = "movie")
    @JsonBackReference
    private List<CalendarShow> calendarShows;

    public Movie() {
    }

    public Movie(int id, String name, Date startDay, Date endDay, String actor, String manufacturer, String director, int duration, String trailer, String image, String detail, Boolean status, List<Employee> employees, List<CalendarShow> calendarShows) {
        this.id = id;
        this.name = name;
        this.startDay = startDay;
        this.endDay = endDay;
        this.actor = actor;
        this.manufacturer = manufacturer;
        this.director = director;
        this.duration = duration;
        this.trailer = trailer;
        this.image = image;
        this.detail = detail;
        this.status = status;
        this.employees = employees;
        this.calendarShows = calendarShows;
    }

    public List<CalendarShow> getCalendarShows() {
        return calendarShows;
    }

    public void setCalendarShows(List<CalendarShow> calendarShows) {
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

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
