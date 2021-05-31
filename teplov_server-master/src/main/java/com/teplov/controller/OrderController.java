package com.teplov.controller;

import com.teplov.entity.Orders;
import com.teplov.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Контроллер для класса {@link Orders}
 */
@RestController
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Получение списка способов доставок
     * @return OK (весь список заказов) и NOT_FOUND, если список пуст
     */
    @GetMapping(value = "/orders")
    public ResponseEntity<List<Orders>> getOrders() {
        List<Orders> orders = orderService.findAll();

        if (orders != null && !orders.isEmpty())
            return new ResponseEntity<>(orders, HttpStatus.OK);

        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Получение доставки по ее id
     * @param id идентификатор заказа
     * @return OK (заказ по его id) и NOT_FOUND, если заказа с таким id не существует
     */
    @GetMapping(value = "/orders/{id}")
    public ResponseEntity<Optional<Orders>> getOrder(@PathVariable("id") Long id) {
        Optional<Orders> order = orderService.findById(id);

        if (order.isPresent())
            return new ResponseEntity<>(order, HttpStatus.OK);

        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Создание способа доставки
     * @param order заказ
     * @return созданный заказа
     */
    @PostMapping(value = "/orders")
    public ResponseEntity<Orders> createOrder(@RequestBody Orders order) {
        Orders order1 = orderService.create(order);
        return new ResponseEntity<>(order1, HttpStatus.CREATED);
    }

    /**
     * Обновление информации о доставке
     * @param order заказ
     * @param orderId id заказа
     * @return OK (обновленные данные о заказе по его id) и NOT_FOUND, если заказа с таким id нет
     */
    @PutMapping(value = "/orders/{id}")
    public ResponseEntity<?> putOrder(@RequestBody Orders order, @PathVariable("id") Long orderId) {
        if (orderService.update(order, orderId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Удаление доставки по ее id
     * @param orderId id заказа
     * @return OK, если удаление прошло успешно и NOT_FOUND, если заказа с таким id не существует
     */
    @DeleteMapping(value = "/orders/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable("id") Long orderId) {
        if (orderService.delete(orderId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
