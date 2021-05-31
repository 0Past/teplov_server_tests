package com.teplov.repository;

import com.teplov.entity.DeliveryType;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Интерфейс для класса {@link DeliveryType}
 */
public interface DeliveryTypeRepository extends JpaRepository<DeliveryType, Long> {
}
