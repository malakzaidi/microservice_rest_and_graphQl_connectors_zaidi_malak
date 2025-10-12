package org.enset.ebanking_service.entities;

import org.enset.ebanking_service.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;


@Projection(types=BankAccount.class,name="p1")
public interface AccountProjection {
    public String getId();
    public AccountType getType();

}
