package com.example.java_tcs.dto;

import com.example.java_tcs.model.Movement;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MovementDto {
    public long id;
    public String description;
    public String amount;
    public long idAccount;

    @JsonIgnore
    public Movement getAsTo() {
        return new Movement(this.id, this.description, this.amount,null);
    }
}