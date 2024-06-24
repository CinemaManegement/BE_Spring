package com.example.spring_cinema.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private int id;

    private Date datePayment;

    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name= "employee_id",referencedColumnName = "employee_id")
    private Employee employee;

    @OneToMany(mappedBy = "invoice")
    @JsonBackReference
    private List<Ticket> tickets;

    public Invoice() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(Date datePayment) {
        this.datePayment = datePayment;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
