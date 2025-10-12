package org.enset.ebanking_service.service;

import org.enset.ebanking_service.dto.BankAccountRequestDTO;
import org.enset.ebanking_service.entities.BankAccount;

import java.util.List;

public interface AccountService {
    BankAccount addAccountEntity(BankAccount bankAccount);
    BankAccount getAccountEntity(String id);
    List<BankAccount> listAccounts();
    BankAccount updateAccountEntity(String id, BankAccountRequestDTO requestDTO);
    void deleteAccount(String id);
}
