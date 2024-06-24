package com.example.spring_cinema.repository.account;

import com.example.spring_cinema.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepo extends JpaRepository<Account,Integer>{
}
