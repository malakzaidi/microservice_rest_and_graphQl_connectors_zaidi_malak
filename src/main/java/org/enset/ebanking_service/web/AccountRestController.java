package org.enset.ebanking_service.web;

import org.enset.ebanking_service.dto.BankAccountRequestDTO;
import org.enset.ebanking_service.dto.BankAccountResponseDTO;
import org.enset.ebanking_service.entities.BankAccount;
import org.enset.ebanking_service.mappers.AccountMapper;
import org.enset.ebanking_service.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    private final AccountService accountService;
    private final AccountMapper accountMapper;

    public AccountRestController(AccountService accountService, AccountMapper accountMapper) {
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }


    @GetMapping("/bankAccounts")
    public List<BankAccountResponseDTO> getAllAccounts() {
        return accountService.listAccounts().stream()
                .map(accountMapper::fromBankAccount)
                .collect(Collectors.toList());
    }


    @GetMapping("/bankAccounts/{id}")
    public BankAccountResponseDTO getAccountById(@PathVariable String id) {
        BankAccount account = accountService.getAccountEntity(id);
        return accountMapper.fromBankAccount(account);
    }


    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO createAccount(@RequestBody BankAccountRequestDTO requestDTO) {
        BankAccount account = accountMapper.fromBankAccountRequestDTO(requestDTO);
        BankAccount saved = accountService.addAccountEntity(account);
        return accountMapper.fromBankAccount(saved);
    }


    @PutMapping("/bankAccounts/{id}")
    public BankAccountResponseDTO updateAccount(@PathVariable String id,
                                                @RequestBody BankAccountRequestDTO requestDTO) {
        BankAccount updated = accountService.updateAccountEntity(id, requestDTO);
        return accountMapper.fromBankAccount(updated);
    }


    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id) {
        accountService.deleteAccount(id);
    }
}
