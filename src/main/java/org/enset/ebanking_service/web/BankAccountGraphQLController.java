package org.enset.ebanking_service.web;

import org.enset.ebanking_service.dto.BankAccountRequestDTO;
import org.enset.ebanking_service.dto.BankAccountResponseDTO;
import org.enset.ebanking_service.entities.BankAccount;
import org.enset.ebanking_service.entities.Customer;
import org.enset.ebanking_service.repositories.BankAccountRepository;
import org.enset.ebanking_service.repositories.CustomerRepository;
import org.enset.ebanking_service.service.AccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


import java.util.List;

@Controller
public class BankAccountGraphQLController {

    private BankAccountRepository  bankAccountRepository;
    private AccountService accountService;
    private CustomerRepository customerRepository;
    public BankAccountGraphQLController(BankAccountRepository bankAccountRepository, AccountService accountService, CustomerRepository customerRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
        this.customerRepository = customerRepository;
    }

    @QueryMapping
    public List<BankAccount>accountsList(){
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount accountById(@Argument String id){
        return bankAccountRepository.findById(id).
                orElseThrow(()->new RuntimeException(String.format("Bank Account Not Found",id)));
    }

    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount) {
        return accountService.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDTO updateAccount(
            @Argument String id,
            @Argument BankAccountRequestDTO bankAccount
    ) {
        if (bankAccount == null) {
            throw new IllegalArgumentException("BankAccount data must not be null");
        }
        return accountService.updateAccount(id, bankAccount);
    }
    @MutationMapping
    public void deleteAccount(@Argument String id) {
        accountService.deleteAccount(id);
    }

    @QueryMapping
    public List<Customer> customers(){
        return customerRepository.findAll();
    }


}



//record BankAccountDTO(Double balance ,String type , String currency){}