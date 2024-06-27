package com.example.spring_cinema.service.customer;

import com.example.spring_cinema.model.Account;
import com.example.spring_cinema.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> listCustomer();
    Page<Customer> customerPage(Pageable pageable, String fullName);
    void addNewCustomer(Customer customer);
    void updateACustomer(Customer customer);
    Customer findById(int id);
    void deleteCustomer(int id);
}
