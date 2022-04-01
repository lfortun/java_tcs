package com.example.java_tcs.service.impl;

import com.example.java_tcs.dto.MovementDto;
import com.example.java_tcs.exception.NoResourceException;
import com.example.java_tcs.model.Account;
import com.example.java_tcs.model.Movement;
import com.example.java_tcs.repository.MovementRepository;
import com.example.java_tcs.service.AccountService;
import com.example.java_tcs.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovementServiceImpl implements MovementService {
    @Autowired
    MovementRepository movementRepository;

    @Autowired
    AccountService accountService;

    @Override
    public List<MovementDto> getAllMovements(long accountId) {
        List<Movement> movement = movementRepository.findAllByAccount_Id(accountId);
        return movement.stream().map(Movement::getAsTo).collect(Collectors.toList());
    }

    @Override
    public MovementDto createMovement(MovementDto movementDto) {
        Account account = accountService.getAccountById(movementDto.idAccount).getAsEntity();
        Movement movement = new Movement(movementDto.id,movementDto.description, movementDto.amount, account);
        return movementRepository.save(movement).getAsTo();
    }

    @Override
    public MovementDto updateClient(Long id, MovementDto movementDto) throws NoResourceException {
        Optional<Movement> movement = movementRepository.findById(id);
        if (movement.isPresent()) {
            movement.get().setId(movementDto.getId());
            movement.get().setDescription(movementDto.getDescription());
            movement.get().setAmount(movementDto.getAmount());
            return movementRepository.save(movement.get()).getAsTo();
        }
        else {
            throw  new NoResourceException("No existe el movimiento con id : "+id);
        }
    }

    @Override
    public void deleteMovement(Long id) throws NoResourceException {
        Optional<Movement> client = movementRepository.findById(id);
        if(client.isPresent()){
            movementRepository.delete(client.get());
        }else{
            throw  new NoResourceException("No existe la persona con id : "+id);
        }
    }
}
