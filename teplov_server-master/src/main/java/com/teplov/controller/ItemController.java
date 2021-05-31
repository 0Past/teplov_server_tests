package com.teplov.controller;

import com.teplov.entity.Item;
import com.teplov.entity.OrderedItem;
import com.teplov.service.CategoryService;
import com.teplov.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Контроллер для класса {@link Item}
 */
@RestController
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService, CategoryService categoryService) {
        this.itemService = itemService;
    }

    /**
     * Получение списка товаров
     * @return OK (весь список товаров) и NOT_FOUND, если список пуст
     */
    @GetMapping(value = "/items")
    public ResponseEntity<List<Item>> getItems() {
        List<Item> items = itemService.findAll();

        if (items != null && !items.isEmpty())
            return new ResponseEntity<>(items, HttpStatus.OK);

        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Получение списка товров в заказе по id заказа
     * @param id идентификатор товара
     * @return OK (список товров по id заказа) и NOT_FOUND, если заказа с таким id или товаров в заказе не существует
     */
    @GetMapping(value = "/items/in_order/{id}")
    public ResponseEntity<List<OrderedItem>> getItemsInOrder(@PathVariable("id") Long id) {
        List<OrderedItem> items = itemService.findAllByOrderId(id);

        if (items != null && !items.isEmpty())
            return new ResponseEntity<>(items, HttpStatus.OK);

        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Получение товара по его id
     * @param id идентификатор товара
     * @return OK (товар по его id) и NOT_FOUND, если товара с таким id не существует
     */
    @GetMapping(value = "/items/{id}")
    private ResponseEntity<Optional<Item>> getItem(@PathVariable("id") Long id) {
        Optional<Item> item = itemService.findById(id);

        if (item.isPresent())
            return new ResponseEntity<>(item, HttpStatus.OK);

        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Удаление товара по его id
     * @param categoryId идентификатор категории
     * @return OK (список товаров из определенной категории) и NOT_FOUND, если категории или товров по данной категории не существует
     */
    @GetMapping(value = "/categories/{category_id}")
    public ResponseEntity<List<Item>> getItemsByCategoryId(@PathVariable("category_id") Long categoryId) {
        List<Item> itemsWithCategory = itemService.findAllByCategoryId(categoryId);

        if (itemsWithCategory != null && !itemsWithCategory.isEmpty())
            return new ResponseEntity<>(itemsWithCategory, HttpStatus.OK);

        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
