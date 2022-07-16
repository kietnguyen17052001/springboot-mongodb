package com.learn.SpringbootMongodb.controller;

import com.learn.SpringbootMongodb.entity.Account;
import com.learn.SpringbootMongodb.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
@AllArgsConstructor

public class AccountController {
    private final IAccountService service;

    @PostMapping
    public ResponseEntity<Account> register(@RequestBody Account account) {
        return new ResponseEntity<>(service.register(account), HttpStatus.CREATED);
    }

}
