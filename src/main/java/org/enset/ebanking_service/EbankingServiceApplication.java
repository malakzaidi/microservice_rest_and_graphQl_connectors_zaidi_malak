package org.enset.ebanking_service;

import org.enset.ebanking_service.entities.BankAccount;
import org.enset.ebanking_service.entities.Customer;
import org.enset.ebanking_service.enums.AccountType;
import org.enset.ebanking_service.repositories.BankAccountRepository;
import org.enset.ebanking_service.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankingServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository) {
        return args -> {
            Stream.of("Ahmed","Malak","Laila","Douaa").forEach(c -> {
                Customer customer = Customer.builder()
                        .name(c)
                        .build();
                customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(c -> {
                for (int i = 1; i <= 10; i++) {
                    BankAccount bankAccount = BankAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
                            .balance(1000+Math.random()*90000)
                            .createdAt(new Date())
                            .currency("MAD")
                            .customer(c)
                            .build();
                    bankAccountRepository.save(bankAccount);
                }
            });

        };
    }



}
