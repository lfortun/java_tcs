package com.example.java_tcs.repository.controller;

import com.example.java_tcs.dto.AccountDto;
import com.example.java_tcs.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "*")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping
    public ResponseEntity<List> getAllAccounts() {
        return new ResponseEntity<List>(accountService.getAllAccounts(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity save(@RequestBody AccountDto accountDto) {
        return new ResponseEntity(accountService.createAccount(accountDto), HttpStatus.OK);
    }
}