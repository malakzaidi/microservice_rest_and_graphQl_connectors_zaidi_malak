package org.enset.ebanking_service.service;

import org.enset.ebanking_service.dto.BankAccountRequestDTO;
import org.enset.ebanking_service.dto.BankAccountResponseDTO;
import org.enset.ebanking_service.entities.BankAccount;
import org.enset.ebanking_service.mappers.AccountMapper;
import org.enset.ebanking_service.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = accountMapper.fromBankAccountRequestDTO(bankAccountDTO);
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());
        BankAccount saved = bankAccountRepository.save(bankAccount);
        return accountMapper.fromBankAccount(saved);
    }

    @Override
    public BankAccountResponseDTO getAccount(String id) {
        BankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        return accountMapper.fromBankAccount(bankAccount);
    }

    @Override
    public List<BankAccountResponseDTO> listAccounts() {
        return bankAccountRepository.findAll()
                .stream()
                .map(accountMapper::fromBankAccount)
                .collect(Collectors.toList());
    }

    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO) {
        BankAccount existing = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (bankAccountDTO.getBalance() != null)
            existing.setBalance(bankAccountDTO.getBalance());
        if (bankAccountDTO.getCurrency() != null)
            existing.setCurrency(bankAccountDTO.getCurrency());
        if (bankAccountDTO.getType() != null)
            existing.setType(bankAccountDTO.getType());
        existing.setCreatedAt(new Date());

        BankAccount updated = bankAccountRepository.save(existing);
        return accountMapper.fromBankAccount(updated);
    }

    @Override
    public void deleteAccount(String id) {
        bankAccountRepository.deleteById(id);
    }
}
