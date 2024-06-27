package com.example.spring_cinema.service.account;

import com.example.spring_cinema.model.Account;
import com.example.spring_cinema.repository.account.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServie implements IAccountService {
    @Autowired
    IAccountRepo iAccountRepo;

    @Override
    public void creatAccount(Account account) {
        iAccountRepo.createAccount(account);
    }

    @Override
    public Account findIdAccountByUserName(String username) {
        return iAccountRepo.findIdAccountByUserName(username);
    }

    @Override
    public boolean isUsernameAvailable(String username) {
        return iAccountRepo.existsByUsername(username);
    }

    @Override
    public void updateStatusAccount(boolean status, int id) {
        iAccountRepo.updateStatusAccount(status, id);
    }
}
