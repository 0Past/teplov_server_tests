package com.teplov.repository;

import com.teplov.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Интерфейс для класса {@link Employee}
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
