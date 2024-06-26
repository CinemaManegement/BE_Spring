package com.example.be_spring.repository.account;


import com.example.be_spring.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepo extends JpaRepository<Account,Integer> {
}
