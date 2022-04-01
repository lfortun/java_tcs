package com.example.java_tcs.service;

import com.example.java_tcs.dto.AccountDto;

import java.util.List;

public interface AccountService {
    List<AccountDto> getAllAccounts();

    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(long idAccount);
}
