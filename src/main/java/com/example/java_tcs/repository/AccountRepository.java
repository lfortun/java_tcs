package com.example.java_tcs.repository;

import com.example.java_tcs.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
