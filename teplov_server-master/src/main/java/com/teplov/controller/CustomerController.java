package com.teplov.controller;

import com.teplov.entity.Customer;
import com.teplov.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Контроллер для класса {@link Customer}
 */
@RestController
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Получение списка покупателей
     * @return OK (весь список покупателей) и NOT_FOUND, если список пуст
     */
    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getCustomers() {
        List<Customer> customers = customerService.findAll();
        if (customers != null && !customers.isEmpty())
            return new ResponseEntity<>(customers, HttpStatus.OK);

        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Получение покупаетля по его id
     * @param id идентификатор покупателя
     * @return OK (покупатель по его id) и NOT_FOUND, если покупателя с таким id не существует
     */
    @GetMapping(value = "/customers/{id}")
    public ResponseEntity<Optional<Customer>> getCustomer(@PathVariable("id") Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent())
            return new ResponseEntity<>(customer, HttpStatus.OK);

        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Создание покупателя
     * @param customer покупатель
     * @return добавленного покупателя
     */
    @PostMapping(value = "/customers")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer) {
        Customer body = customerService.create(customer);
        return new ResponseEntity<>(body, HttpStatus.CREATED);
    }

    /**
     * Обновление информации о покупателе п оего id
     * @param customer покупатель
     * @param customerId id покупателя
     * @return OK (обновленные данные о покупателе по его id) и NOT_FOUND, если покупателя с таким id не существует
     */
    @PutMapping(value = "/customers/{id}")
    public ResponseEntity<?> putCustomer(@RequestBody Customer customer, @PathVariable("id") Long customerId) {
        if (customerService.update(customer, customerId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Удаление покупателя по его id
     * @param customerId id покупателя
     * @return OK, если удаление прошло успешно и NOT_FOUND, если покупателя с таким id не существует
     */
    @DeleteMapping(value = "/customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long customerId) {
        if (customerService.delete(customerId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
