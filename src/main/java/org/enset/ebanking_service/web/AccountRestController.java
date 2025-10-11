package org.enset.ebanking_service.web;

import org.enset.ebanking_service.entities.BankAccount;
import org.enset.ebanking_service.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;

    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }
    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("bank account not found",id)));
    }
    @PostMapping("/bankAccounts")
    public BankAccount save (@RequestBody BankAccount bankAccount){
        return bankAccountRepository.save(bankAccount);
    }
    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id, @RequestBody BankAccount bankAccount){
        BankAccount account = bankAccountRepository.findById(id).orElseThrow();
        if (account.getBalance()!=null) account.setBalance(bankAccount.getBalance());
        if (account.getCreatedAt()!=null) account.setCreatedAt(new Date());
        if (account.getType()!=null) account.setType(bankAccount.getType());
        if(account.getCurrency()!=null) account.setCurrency(bankAccount.getCurrency());
        return bankAccountRepository.save(account);
    }
    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount (@PathVariable String id){
        bankAccountRepository.deleteById(id);

    }

}
