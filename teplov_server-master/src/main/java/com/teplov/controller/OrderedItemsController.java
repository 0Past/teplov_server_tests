package com.teplov.controller;

import com.teplov.entity.OrderedItem;
import com.teplov.service.OrderedItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для класса {@link OrderedItem}
 */
@RestController
public class OrderedItemsController {

    private OrderedItemService orderedItemService;

    @Autowired
    public OrderedItemsController(OrderedItemService orderedItemService) {
        this.orderedItemService = orderedItemService;
    }

    /**
     * Добавление товара в заказ
     * @param orderedItems товар в заказе
     * @return добавленный в заказ товар
     */
    @PostMapping(value = "/ordered_items/add_all")
    public ResponseEntity<?> addOrderedItems(@RequestBody Iterable<OrderedItem> orderedItems) {
        orderedItemService.addItems(orderedItems);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
