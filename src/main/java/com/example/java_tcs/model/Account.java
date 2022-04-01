package com.example.java_tcs.model;

import com.example.java_tcs.dto.AccountDto;
import com.example.java_tcs.dto.MovementDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String customerName;
    public String accountNumber;
    public String accountType;
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Movement> movements;

    public AccountDto getAsTo() {
        List<MovementDto> movements = this.movements != null ? this.movements.stream().map(Movement::getAsTo).collect(Collectors.toList())
                : null;
        return new AccountDto(this.id, this.customerName, this.accountNumber, this.accountType,
                movements);
    }
}