package org.enset.ebanking_service.repositories;

import org.enset.ebanking_service.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
