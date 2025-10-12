package org.enset.ebanking_service.web;


import org.enset.ebanking_service.entities.BankAccount;
import org.enset.ebanking_service.repositories.BankAccountRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {

    private BankAccountRepository  bankAccountRepository;
    public BankAccountGraphQLController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @QueryMapping
    public List<BankAccount>accountList(){
        return bankAccountRepository.findAll();
    }

}
