package com.teplov.service;

import com.teplov.entity.Category;
import com.teplov.entity.Customer;
import com.teplov.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * Сервис для класса {@link Customer}
 */
@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    /**
     * Получние всех записей из покупателя
     * @return все покупатели
     */
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
    /**
     * Получение записи по его id
     * @param id идентификатор покупателя
     * @return запись по id
     */
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }
    /**
     * Создание покупателя
     * @param customer покупатель
     * @return созданный покупатель
     */
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }
    /**
     * Удаление покупателя по его id
     * @param id идентификатор покупателя
     * @return true, если покупатель удалился и false, если покупателя с таким id нет
     */
    public boolean delete(Long id) {
        if (findById(id).isPresent()) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }
    /**
     * Обновление информации о покупаетле по его id
     * @param customer покупатель
     * @param id идентификатор покупателя
     * @return обновленная информация
     */
    public boolean update(Customer customer, Long id) {
        if (findById(id).isPresent()) {
            customer.setId(id);
            customerRepository.save(customer);
            return true;
        }
        return false;
    }
}
