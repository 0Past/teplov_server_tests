package com.teplov.service;

import com.teplov.entity.Orders;
import com.teplov.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * Сервис для класса {@link Orders}
 */
@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    /**
     * Получние всех записей из заказа
     * @return все заказы
     */
    public List<Orders> findAll() {
        return orderRepository.findAll();
    }
    /**
     * Получение записи по его id
     * @param id идентификатор заказа
     * @return запись по id
     */
    public Optional<Orders> findById(Long id) {
        return orderRepository.findById(id);
    }
    /**
     * Создание заказа
     * @param orders заказа
     * @return созданный заказ
     */
    public Orders create(Orders orders) {
        return orderRepository.save(orders);
    }
    /**
     * Удаление заказа по его id
     * @param id идентификатор заказа
     * @return true, если заказ удалился и false, если заказа с таким id нет
     */
    public boolean delete(Long id) {
        if (findById(id).isPresent()) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }
    /**
     * Обновление информации о заказе по его id
     * @param orders заказ
     * @param id идентификатор заказа
     * @return обновленная информация
     */
    public boolean update(Orders orders, Long id) {
        if (findById(id).isPresent()) {
            orders.setId(id);
            orderRepository.save(orders);
            return true;
        }
        return false;
    }
}
