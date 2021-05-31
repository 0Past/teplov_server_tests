package com.teplov.repository;

import com.teplov.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс для класса {@link Customer}
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
