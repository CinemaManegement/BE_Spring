package com.example.spring_cinema.service.customer;

import com.example.spring_cinema.model.Account;
import com.example.spring_cinema.model.Customer;
import com.example.spring_cinema.repository.customer.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    ICustomerRepo iCustomerRepo;

    @Override
    public List<Customer> listCustomer() {
        return iCustomerRepo.findAll();
    }

    @Override
    public Page<Customer> customerPage(Pageable pageable, String fullName) {
        return iCustomerRepo.findAllByFullNameContaining(pageable, fullName);
    }

    @Override
    public void addNewCustomer(Customer customer) {
        iCustomerRepo.createCustomer(customer);
    }

    @Override
    public void updateACustomer(Customer customer) {
        iCustomerRepo.updateCustomer(customer);
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteCustomer(int id) {
        iCustomerRepo.deleteCustomer(id);
    }
}
