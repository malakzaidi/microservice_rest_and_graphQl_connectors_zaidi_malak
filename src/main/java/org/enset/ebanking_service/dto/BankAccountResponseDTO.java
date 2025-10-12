package org.enset.ebanking_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.enset.ebanking_service.enums.AccountType;

import java.util.Date;

@Data @NoArgsConstructor
@AllArgsConstructor @Builder
public class BankAccountResponseDTO {
    public String id;
    public Date createdAt;
    public Double balance;
    public String currency;
    private AccountType type;
}
