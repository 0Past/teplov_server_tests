package com.teplov.service;

import com.teplov.entity.Inventory;
import com.teplov.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * Сервис для класса {@link Inventory}
 */
@Service
public class InventoryService {

    private InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }
    /**
     * Получние всех записей из склада
     * @return все товары на складе
     */
    public List<Inventory> findAll() {
        return inventoryRepository.findAll();
    }
    /**
     * Получение записи по ее id
     * @param id идентификатор товара на складе
     * @return запись по id
     */
    public Optional<Inventory> findById(Long id) {
        return inventoryRepository.findById(id);
    }
    /**
     * Создание товара на складе
     * @param inventory товар на складе
     * @return созданный товар на складе
     */
    public Inventory create(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    /**
     * Получение записи по ее категории
     * @param category категория
     * @return запись по категории
     */
    public List<Inventory> findByCategory(String category) {
        return inventoryRepository.findByCategory(category);
    }
    /**
     * Удаление товкара на складе по его id
     * @param id идентификатор товара на складе
     * @return true, если сотрудник удалился и false, если сотрудника с таким id нет
     */
    public boolean delete(Long id) {
        if (findById(id).isPresent()) {
            inventoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
    /**
     * Обновление информации о товаре на складе по его id
     * @param inventory товар на складе
     * @param id идентификатор товара на складе
     * @return обновленная информация
     */
    public boolean update(Inventory inventory, Long id) {
        if (findById(id).isPresent()) {
            inventory.setId(id);
            inventoryRepository.save(inventory);
            return true;
        }
        return false;

    }
}
