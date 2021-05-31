package com.teplov.service;

import com.teplov.entity.Employee;
import com.teplov.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для класса {@link Employee}
 */
@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    /**
     * Получние всех записей из сотрудника
     * @return все покупатели
     */
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
    /**
     * Получение записи по его id
     * @param id идентификатор сотрудника
     * @return запись по id
     */
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }
    /**
     * Создание сотрудника
     * @param employee сотрудник
     * @return созданный сотрудника
     */
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }
    /**
     * Удаление сотрудника по его id
     * @param id идентификатор сотрудника
     * @return true, если сотрудник удалился и false, если сотрудника с таким id нет
     */
    public boolean delete(Long id) {
        if (findById(id).isPresent()) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
    /**
     * Обновление информации о сотруднике по его id
     * @param employee сотрудник
     * @param id идентификатор сотрудник
     * @return обновленная информация
     */
    public boolean update(Employee employee, Long id) {
        if (findById(id).isPresent()) {
            employee.setId(id);
            employeeRepository.save(employee);
            return true;
        }
        return false;

    }
}