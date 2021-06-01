package com.teplov.service;

import com.teplov.entity.Customer;
import com.teplov.repository.CustomerRepository;
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
public class CustomerServiceTest {

    @Autowired
    private CustomerService service;

    @MockBean
    private CustomerRepository repository;

    @Test
    public void findAll() {
        ArrayList<Customer> expected = new ArrayList<>();
        Customer customer = new Customer();
        expected.add(customer);
        Mockito.when(service.findAll()).thenReturn(expected);
        Assert.assertEquals(service.findAll(), expected);
    }

    @Test
    public void findById() {
        Optional<Customer> expected = Optional.of(new Customer());
        Mockito.doReturn(expected)
                .when(repository)
                .findById(1L);
        Assert.assertEquals(expected, service.findById(1L));
    }

    @Test
    public void create() {
        Customer expected = new Customer();
        Customer customer = new Customer();
        Mockito.doReturn(expected)
                .when(repository)
                .save(customer);
        Assert.assertEquals(expected, service.create(customer));
    }

    @Test
    public void delete() {
        Mockito.doReturn(Optional.of(new Customer()))
                .when(repository)
                .findById(1L);
        Assert.assertTrue(service.delete(1L));
    }

    @Test
    public void update() {
        Mockito.doReturn(Optional.of(new Customer()))
                .when(repository)
                .findById(1L);
        Assert.assertTrue(service.update(new Customer(), 1L));
    }
}
