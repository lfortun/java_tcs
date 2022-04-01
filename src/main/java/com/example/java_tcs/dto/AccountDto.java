package com.example.java_tcs.dto;

import com.example.java_tcs.model.Account;
import com.example.java_tcs.model.Movement;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class AccountDto {
    public long id;
    public String customerName;
    public String accountNumber;
    public String accountType;
    public List<MovementDto> movements;

    @JsonIgnore
    public Account getAsEntity(){
        List<Movement> movements = this.movements != null ? this.movements.stream().map(MovementDto::getAsTo).collect(Collectors.toList())
                :null;
        return new Account(this.id,this.customerName,this.accountNumber,this.accountType,
                movements);
    }


}
