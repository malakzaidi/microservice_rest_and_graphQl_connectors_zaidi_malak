package org.enset.ebanking_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.enset.ebanking_service.enums.AccountType;

@Data @NoArgsConstructor
@AllArgsConstructor @Builder
public class BankAccountRequestDTO {
    public Double balance;
    public String currency;
    private AccountType type;
}
