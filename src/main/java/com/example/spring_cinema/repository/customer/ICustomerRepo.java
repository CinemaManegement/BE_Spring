package com.example.spring_cinema.repository.customer;

import com.example.spring_cinema.model.Account;
import com.example.spring_cinema.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ICustomerRepo extends JpaRepository<Customer, Integer> {
    Page<Customer> findAllByFullNameContaining(Pageable pageable, String fullName);

    @Modifying
    @Transactional
    @Query(value = "insert into Customer(full_name,birth_day,gender,id_card,email,address,phone,account_id) " +
            "values (:#{#customer.fullName}, :#{#customer.birthDay}, :#{#customer.gender}, :#{#customer.idCard}, " +
            ":#{#customer.email}, :#{#customer.address}, :#{#customer.phone}, :#{#customer.account.id})",
            nativeQuery = true)
    void createCustomer(@Param("customer") Customer customer);

    @Modifying
    @Transactional
    @Query("update Customer c set c.fullName = :#{#customer.fullName}, c.birthDay = :#{#customer.birthDay}, " +
            "c.gender = :#{#customer.gender}, c.idCard = :#{#customer.idCard}, c.email = :#{#customer.email}, " +
            "c.address = :#{#customer.address}, c.phone = :#{#customer.phone} where c.id = :#{#customer.id}")
    void updateCustomer(@Param("customer") Customer customer);

    @Modifying
    @Transactional
    @Query("delete from Customer c where c.id = :id")
    void deleteCustomer(@Param("id") int id);
}
