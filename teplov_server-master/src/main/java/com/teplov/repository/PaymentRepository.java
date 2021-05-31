package com.teplov.repository;

import com.teplov.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Интерфейс для класса {@link Payment}
 */
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
