package org.enset.ebanking_service.web;

import org.enset.ebanking_service.dto.BankAccountRequestDTO;
import org.enset.ebanking_service.dto.BankAccountResponseDTO;
import org.enset.ebanking_service.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    private final AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccountResponseDTO> getAllAccounts() {
        return accountService.listAccounts();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccountResponseDTO getAccountById(@PathVariable String id) {
        return accountService.getAccount(id);
    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO createAccount(@RequestBody BankAccountRequestDTO requestDTO) {
        return accountService.addAccount(requestDTO);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccountResponseDTO updateAccount(@PathVariable String id, @RequestBody BankAccountRequestDTO requestDTO) {
        return accountService.updateAccount(id, requestDTO);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id) {
        accountService.deleteAccount(id);
    }
}
