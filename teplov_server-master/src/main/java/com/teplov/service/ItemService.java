package com.teplov.service;

import com.teplov.entity.Item;
import com.teplov.entity.OrderedItem;
import com.teplov.repository.ItemRepository;
import com.teplov.repository.OrderedItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * Сервис для класса {@link Item}
 */
@Service
public class ItemService {

    private ItemRepository itemRepository;

    private OrderedItemRepository orderedItemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository, OrderedItemRepository orderedItemRepository) {
        this.itemRepository = itemRepository;
        this.orderedItemRepository = orderedItemRepository;
    }
    /**
     * Получние всех записей товаров
     * @return все товары
     */
    public List<Item> findAll() {
        return itemRepository.findAll();
    }
    /**
     * Получение записи по его id
     * @param id идентификатор товара
     * @return запись по id
     */
    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

    /**
     * Получение записи по категории
     * @param categoryId id категории
     * @return запись по id категории
     */
    public List<Item> findAllByCategoryId(Long categoryId) {
        return itemRepository.findAllByCategoryId(categoryId);
    }

    /**
     * Получение записи по id заказа
     * @param orderId id заказа
     * @return запись по id заказа
     */
    public List<OrderedItem> findAllByOrderId(Long orderId) {
        return orderedItemRepository.findByOrderId(orderId);
    }
    /**
     * Создание товара
     * @param item товара
     * @return созданный товара
     */
    public Item create(Item item) {
        return itemRepository.save(item);
    }
    /**
     * Удаление товара по его id
     * @param id идентификатор товара
     * @return true, если товар удалился и false, если товара с таким id нет
     */
    public boolean delete(Long id) {
        if (findById(id).isPresent()) {
            itemRepository.deleteById(id);
            return true;
        }
        return false;
    }
    /**
     * Обновление информации о товаре по его id
     * @param item товар
     * @param id идентификатор товара
     * @return обновленная информация
     */
    public boolean update(Item item, Long id) {
        if (findById(id).isPresent()) {
            item.setId(id);
            itemRepository.save(item);
            return true;
        }
        return false;

    }
}
