package org.enset.ebanking_service.service;

import org.enset.ebanking_service.dto.BankAccountRequestDTO;
import org.enset.ebanking_service.entities.BankAccount;
import org.enset.ebanking_service.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public BankAccount addAccountEntity(BankAccount bankAccount) {
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());
        return bankAccountRepository.save(bankAccount);
    }

    @Override
    public BankAccount getAccountEntity(String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bank account not found with ID: " + id));
    }

    @Override
    public List<BankAccount> listAccounts() {
        return bankAccountRepository.findAll();
    }

    @Override
    public BankAccount updateAccountEntity(String id, BankAccountRequestDTO requestDTO) {
        BankAccount existing = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bank account not found with ID: " + id));

        if (requestDTO.getBalance() != null)
            existing.setBalance(requestDTO.getBalance());
        if (requestDTO.getCurrency() != null)
            existing.setCurrency(requestDTO.getCurrency());
        if (requestDTO.getType() != null)
            existing.setType(requestDTO.getType());

        existing.setCreatedAt(new Date()); // optional: update date when edited

        return bankAccountRepository.save(existing);
    }

    @Override
    public void deleteAccount(String id) {
        bankAccountRepository.deleteById(id);
    }
}
