package com.teplov.repository;

import com.teplov.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
/**
 * Интерфейс для класса {@link Item}
 */
public interface ItemRepository extends JpaRepository<Item, Long> {
    /**
     * Запрос для получения товаров по заданной категории (id категории)
     * @param categoryId id категории
     * @return список товаров по категории
     */
    @Query(value = "SELECT * FROM Item WHERE category_id = :categoryId", nativeQuery = true)
    List<Item> findAllByCategoryId(@Param("categoryId") Long categoryId);


}
