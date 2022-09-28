package com.example.forportfoliyo.service;

import com.example.forportfoliyo.entity.Account;
import com.example.forportfoliyo.entity.Department;
import com.example.forportfoliyo.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

   public final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public Account save(Account account){
        return accountRepository.save(account);
    }

    public List<Account> getAll(){
        List<Account> all = accountRepository.findAll();
        return all;
    }
}
