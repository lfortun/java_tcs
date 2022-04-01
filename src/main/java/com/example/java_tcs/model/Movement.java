package com.example.java_tcs.model;

import com.example.java_tcs.dto.MovementDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String description;
    public String amount;
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Account account;

    public MovementDto getAsTo() {
        return new MovementDto(this.id, this.description, this.amount, this.account.id);
    }
}
