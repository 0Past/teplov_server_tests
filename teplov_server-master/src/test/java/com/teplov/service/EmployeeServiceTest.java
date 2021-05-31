package com.teplov.service;

import com.teplov.entity.Employee;
import com.teplov.repository.EmployeeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService service;

    @MockBean
    private EmployeeRepository repository;

    @Test
    public void findAll() {
        ArrayList<Employee> expected = new ArrayList<>();

        Employee employee = new Employee();
        expected.add(employee);

        Mockito.when(service.findAll()).thenReturn(expected);
        Assert.assertEquals(service.findAll(), expected);
    }

    @Test
    public void findById() {
        Optional<Employee> expected = Optional.of(new Employee());

        Mockito.doReturn(expected)
                .when(repository)
                .findById(1L);

        Assert.assertEquals(expected, service.findById(1L));
    }

    @Test
    public void create() {
        Employee expected = new Employee();
        Employee employee = new Employee();

        Mockito.doReturn(expected)
                .when(repository)
                .save(employee);

        Assert.assertEquals(expected, service.create(employee));
    }

    @Test
    public void delete() {
        Mockito.doReturn(Optional.of(new Employee()))
                .when(repository)
                .findById(1L);

        Assert.assertTrue(service.delete(1L));
    }

    @Test
    public void update() {
        Mockito.doReturn(Optional.of(new Employee()))
                .when(repository)
                .findById(1L);

        Assert.assertTrue(service.update(new Employee(), 1L));
    }
}