package com.teplov.repository;

import com.teplov.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Интерфейс для класса {@link Category}
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
