package com.example.forportfoliyo.web.rest;


import com.example.forportfoliyo.entity.Account;
import com.example.forportfoliyo.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountResource {

    public final AccountService accountService;

    public AccountResource(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/accounts")
    public ResponseEntity create(@RequestBody Account account){
        Account save = accountService.save(account);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/accounts")
    public List<Account> getAll(){
        List<Account> all = accountService.getAll();
        return all;
    }
}
