package com.teplov.controller;


import com.teplov.entity.Inventory;
import com.teplov.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для класса {@link Inventory}
 */
@RestController
public class InventoryController {

    private InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    /**
     * Получение списка товаров на складе
     * @return OK (весь список склада) и NOT_FOUND, если список пуст
     */
    @GetMapping(value = "/inventory")
    public ResponseEntity<List<Inventory>> getInventoryItems() {
        List<Inventory> inventories = inventoryService.findAll();
        if (inventories != null && !inventories.isEmpty())
            return new ResponseEntity<>(inventories, HttpStatus.OK);

        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Получение списка товаров по заданной категории
     * @param category категория
     * @return OK (категорию) и NOT_FOUND, если такой категории не существует
     */
    @GetMapping(value = "/inventory/{category}")
    public ResponseEntity<List<Inventory>> getInventoryItem(@PathVariable String category) {
        List<Inventory> inventories = inventoryService.findByCategory(category);
        if (inventories != null && !inventories.isEmpty())
            return new ResponseEntity<>(inventories, HttpStatus.OK);

        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Добавление товаров на склад
     * @param inventory склад
     * @return добавленный товар на склад
     */
    @PostMapping(value = "/inventory")
    public ResponseEntity<Inventory> saveInventoryItem(@RequestBody Inventory inventory) {
        Inventory inventory1 = inventoryService.create(inventory);
        return new ResponseEntity<>(inventory1, HttpStatus.CREATED);
    }

    /**
     * Обновление информации о товаре на складе по его id
     * @param id идентификатор товара на складе
     * @param inventory товар на складе
     * @return OK (товар со склада по его id) и NOT_FOUND, если товара на складе с таким id не существует
     */
    @PutMapping(value = "/inventory/{id}")
    public ResponseEntity<?> putInventoryItem(@PathVariable Long id, @RequestBody Inventory inventory) {
        if (inventoryService.update(inventory, id))
            return new ResponseEntity<>(inventory, HttpStatus.OK);

        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Удаление товара по его id
     * @param id идентификатор товара на складе
     * @return OK, если удаление прошло успешно и NOT_FOUND, если товара на складе с таким id не существует
     */
    @DeleteMapping(value = "/inventory/{id}")
    public ResponseEntity<?> deleteInventoryItem(@PathVariable Long id) {
        if (inventoryService.delete(id))
            return new ResponseEntity<>(HttpStatus.OK);

        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
