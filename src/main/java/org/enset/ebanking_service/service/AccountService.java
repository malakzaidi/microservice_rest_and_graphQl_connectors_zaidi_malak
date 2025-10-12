package org.enset.ebanking_service.service;

import org.enset.ebanking_service.dto.BankAccountRequestDTO;
import org.enset.ebanking_service.dto.BankAccountResponseDTO;

import java.util.List;

public interface AccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
    BankAccountResponseDTO getAccount(String id);
    List<BankAccountResponseDTO> listAccounts();
    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
    void deleteAccount(String id);
}
