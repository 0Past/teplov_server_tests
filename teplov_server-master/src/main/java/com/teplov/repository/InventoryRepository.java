package com.teplov.repository;

import com.teplov.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
/**
 * Интерфейс для класса {@link Inventory}
 */
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    /**
     * Запрос для получения списка товаров на складе используя id товара и его категорию
     * @param category категория
     * @return товары на складе
     */
    @Query(nativeQuery = true, value = "SELECT * " +
            "FROM Inventory " +
            "WHERE item_id IN " +
            "(SELECT id FROM Item WHERE category_id " +
            "IN (SELECT id FROM Category WHERE title = :category))")
    List<Inventory> findByCategory(@Param("category") String category);

}
