package org.enset.ebanking_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.enset.ebanking_service.enums.AccountType;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor @Builder
public class BankAccount {
    @Id
    public String id;
    public Date createdAt;
    public double balance;
    public String currency;
    private AccountType type;
}
