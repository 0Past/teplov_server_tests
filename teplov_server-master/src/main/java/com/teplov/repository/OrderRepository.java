package com.teplov.repository;

import com.teplov.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Интерфейс для класса {@link Orders}
 */
public interface OrderRepository extends JpaRepository<Orders, Long> {

}
