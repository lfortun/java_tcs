package com.example.java_tcs.service;

import com.example.java_tcs.dto.MovementDto;
import com.example.java_tcs.exception.NoResourceException;

import java.util.List;

public interface MovementService {
    List<MovementDto> getAllMovements(long accountId);
    MovementDto createMovement(MovementDto movementDto);
    MovementDto updateClient(Long id, MovementDto clientDto) throws NoResourceException;
    void deleteMovement(Long id) throws NoResourceException;
}
