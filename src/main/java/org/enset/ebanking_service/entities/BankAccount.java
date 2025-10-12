package org.enset.ebanking_service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.enset.ebanking_service.dto.BankAccountResponseDTO;
import org.enset.ebanking_service.enums.AccountType;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor @Builder
public class BankAccount  {
    @Id
    public String id;
    public Date createdAt;
    public Double balance;
    public String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @ManyToOne
    private Customer customer;
}
