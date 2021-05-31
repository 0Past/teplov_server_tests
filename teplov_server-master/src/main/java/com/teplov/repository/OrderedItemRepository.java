package com.teplov.repository;

import com.teplov.entity.OrderedItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
/**
 * Интерфейс для класса {@link OrderedItem}
 */
public interface OrderedItemRepository extends JpaRepository<OrderedItem, Long> {
    /**
     * Запрос для получения товаров по заданному id заказа
     * @param order_id id заказа
     * @return список товаров из заказа
     */
    @Query(value = "SELECT * FROM ordered_item WHERE order_id = :order_id", nativeQuery = true)
    List<OrderedItem> findByOrderId(@Param("order_id") Long order_id);

}
