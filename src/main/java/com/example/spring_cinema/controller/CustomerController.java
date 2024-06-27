package com.example.spring_cinema.controller;

import com.example.spring_cinema.model.Account;
import com.example.spring_cinema.model.Customer;
import com.example.spring_cinema.model.Role;
import com.example.spring_cinema.service.account.IAccountService;
import com.example.spring_cinema.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;
    @Autowired
    IAccountService iAccountService;
    @GetMapping("")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> customerList = iCustomerService.listCustomer();
        if(customerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerList,HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Customer>> pageCustomer(@RequestParam(defaultValue = "0",required = false) int page,
                                                       @RequestParam(defaultValue = "",required = false) String fullName,
                                                       @RequestParam(defaultValue = "id",required = false) String sort,
                                                       @RequestParam(defaultValue = "5",required = false) int row) {
        Sort sort1 = Sort.by(Sort.Direction.ASC,sort);
        Pageable pageable = PageRequest.of(page,row,sort1);
        Page<Customer> page1 = iCustomerService.customerPage(pageable,fullName);
        if(page1.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(page1,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Customer customer) {
        if(customer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(iAccountService.isUsernameAvailable(customer.getAccount().getUsername())) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Role role = new Role(1,"customer");
        Account account = customer.getAccount();
        account.setStatus(Boolean.TRUE);
        account.setRole(role);
        iAccountService.creatAccount(account);
        Account account1 = iAccountService.findIdAccountByUserName(account.getUsername());
        customer.setAccount(account1);
        iCustomerService.addNewCustomer(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/edit")
    public ResponseEntity<?> update(@RequestBody Customer customer) {
        Customer customerFind = iCustomerService.findById(customer.getCustomerId());
        if(customerFind == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iCustomerService.updateACustomer(customer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Customer customer = iCustomerService.findById(id);
        if(customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        int idAccount = customer.getAccount().getId();
        iCustomerService.deleteCustomer(id);
        iAccountService.updateStatusAccount(Boolean.FALSE, idAccount);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
