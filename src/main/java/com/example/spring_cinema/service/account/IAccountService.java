package com.example.spring_cinema.service.account;

import com.example.spring_cinema.model.Account;

public interface IAccountService {
    void creatAccount(Account account);
    Account findIdAccountByUserName(String username);
    boolean isUsernameAvailable(String username);
    void updateStatusAccount(boolean status, int id);
}
