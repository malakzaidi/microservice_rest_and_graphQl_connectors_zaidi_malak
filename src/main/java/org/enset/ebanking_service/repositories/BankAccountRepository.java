package org.enset.ebanking_service.repositories;

import org.enset.ebanking_service.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
