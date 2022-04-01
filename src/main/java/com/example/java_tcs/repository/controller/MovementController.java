package com.example.java_tcs.repository.controller;

import com.example.java_tcs.dto.MovementDto;
import com.example.java_tcs.exception.NoResourceException;
import com.example.java_tcs.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movements")
@CrossOrigin(origins = "*")
public class MovementController {
    @Autowired
    private MovementService movementService;

    @GetMapping
    public ResponseEntity<List> getAllMovement(@RequestParam long accountId) {
        return new ResponseEntity<List>(movementService.getAllMovements(accountId), HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity save(@RequestBody MovementDto movementDto) {
        return new ResponseEntity(movementService.createMovement(movementDto), HttpStatus.OK);
    }

    @PutMapping("/movement/{id}")
    public ResponseEntity update(@PathVariable(value = "id") Long personId, @RequestBody MovementDto clientDto) {
        try {
            return new ResponseEntity(movementService.updateClient(personId, clientDto), HttpStatus.OK);
        } catch (NoResourceException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/movement/{Id}")
    public ResponseEntity deleteMovement(@PathVariable(value = "Id") Long id) {
        try {
            movementService.deleteMovement(id);
            return new ResponseEntity("Se elimino la entidad",HttpStatus.OK);
        } catch (NoResourceException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
