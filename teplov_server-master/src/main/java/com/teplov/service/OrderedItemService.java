package com.teplov.service;

import com.teplov.entity.OrderedItem;
import com.teplov.repository.OrderedItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Сервис для класса {@link OrderedItem}
 */
@Service
public class OrderedItemService {

    private OrderedItemRepository orderRepository;

    @Autowired
    public OrderedItemService(OrderedItemRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Добавление товара в заказ
     *
     * @param items товары
     */
    public boolean addItems(Iterable<OrderedItem> items) {
        orderRepository.saveAll(items);
        return true;
    }
}
