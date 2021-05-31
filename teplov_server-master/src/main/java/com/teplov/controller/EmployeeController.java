package com.teplov.controller;

import com.teplov.entity.Employee;
import com.teplov.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Контроллер для класс {@link Employee}
 */
@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Получение списка сотрудников
     * @return OK (весь список сотрудников) и NOT_FOUND, если список пуст
     */
    @GetMapping(value = "/employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = employeeService.findAll();

        if (employees != null && !employees.isEmpty())
            return new ResponseEntity<>(employees, HttpStatus.OK);

        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Получение списка сотрудников
     * @param employee сотрудник
     * @return созданный сотрудник
     */
    @PostMapping(value = "/employees")
    public ResponseEntity<Employee> postEmployee(@RequestBody Employee employee) {
        Employee body = employeeService.create(employee);
        return new ResponseEntity<>(body, HttpStatus.CREATED);
    }

    /**
     * Получение сотрудника по его id
     * @param id идентификатор сотрудника
     * @return OK (сотрудника по его id) и NOT_FOUND, если сотрудника с таким id не существует
     */
    @GetMapping(value = "/employees/{id}")
    public ResponseEntity<Optional<Employee>> getEmployee(@PathVariable("id") Long id) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isPresent())
            return new ResponseEntity<>(employee, HttpStatus.OK);

        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Обновление информации о сотруднике по его id
     * @param employee сотрудник
     * @param employeeId id сотрудника
     * @return OK (обновленные данные о сотруднике по его id) и NOT_FOUND, если сотрудника с таким id нет
     */
    @PutMapping(value = "/employees/{id}")
    public ResponseEntity<?> putEmployee(@RequestBody Employee employee, @PathVariable("id") Long employeeId) {
        if (employeeService.update(employee, employeeId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    /**
     * Удаление сотрудника по его id
     * @param employeeId id сотрудника
     * @return OK, если удаление прошло успешно и NOT_FOUND, если сотрудника с таким id не существует
     */
    @DeleteMapping(value = "/employees/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long employeeId) {
        if (employeeService.delete(employeeId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
