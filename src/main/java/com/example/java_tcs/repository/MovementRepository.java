package com.example.java_tcs.repository;

import com.example.java_tcs.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovementRepository extends JpaRepository<Movement, Long> {
    List<Movement> findAllByAccount_Id(long accountId);
}
