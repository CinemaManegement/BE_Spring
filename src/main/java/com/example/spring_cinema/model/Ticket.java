package com.example.spring_cinema.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private int ticketId;

    @ManyToOne
    @JoinColumn(name = "calendar_show_id",referencedColumnName = "calendar_show_id")
    private CalendarShow calendarShow;

    @ManyToOne
    @JoinColumn(name = "invoice_id",referencedColumnName = "invoice_id")
    private Invoice invoice;

    @OneToMany(mappedBy = "ticket")
    @JsonBackReference
    private List<Seat> seat;

    public Ticket() {
    }

    public Ticket(int ticketId, CalendarShow calendarShow, Invoice invoice) {
        this.ticketId = ticketId;
        this.calendarShow = calendarShow;
        this.invoice = invoice;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public CalendarShow getCalendarShow() {
        return calendarShow;
    }

    public void setCalendarShow(CalendarShow calendarShow) {
        this.calendarShow = calendarShow;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
