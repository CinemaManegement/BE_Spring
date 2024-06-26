package com.example.be_spring.repository.customer;

import com.example.be_spring.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepo extends JpaRepository<Customer, Integer> {
}
