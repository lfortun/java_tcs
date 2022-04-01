package com.example.java_tcs.service.impl;

import com.example.java_tcs.dto.AccountDto;
import com.example.java_tcs.model.Account;
import com.example.java_tcs.repository.AccountRepository;
import com.example.java_tcs.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> account = accountRepository.findAll();

        return account.stream().map(Account::getAsTo).collect(Collectors.toList());
    }

    @Override
    public AccountDto getAccountById(long idAccount) {
        return accountRepository.findById(idAccount).orElseThrow().getAsTo();
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        return accountRepository.save(accountDto.getAsEntity()).getAsTo();
    }
}
