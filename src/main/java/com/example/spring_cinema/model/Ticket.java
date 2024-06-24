package com.example.spring_cinema.model;

import jakarta.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "calendar_show_id",referencedColumnName = "calendar_show_id")
    private CalendarShow calendarShow;

    @ManyToOne
    @JoinColumn(name = "invoice_id",referencedColumnName = "invoice_id")
    private Invoice invoice;

    public Ticket() {
    }

    public Ticket(int id, CalendarShow calendarShow, Invoice invoice) {
        this.id = id;
        this.calendarShow = calendarShow;
        this.invoice = invoice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
