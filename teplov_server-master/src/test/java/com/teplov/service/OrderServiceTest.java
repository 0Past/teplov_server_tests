package com.teplov.service;

import com.teplov.entity.Customer;
import com.teplov.entity.Orders;
import com.teplov.repository.OrderRepository;
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
public class OrderServiceTest {

    @Autowired
    private OrderService service;

    @MockBean
    private OrderRepository repository;

    @Test
    public void findAll() {
        ArrayList<Orders> expected = new ArrayList<>();
        Orders orders = new Orders();
        expected.add(orders);
        Mockito.when(service.findAll()).thenReturn(expected);
        Assert.assertEquals(service.findAll(), expected);
    }

    @Test
    public void findById() {
        Optional<Orders> expected = Optional.of(new Orders());
        Mockito.doReturn(expected)
                .when(repository)
                .findById(1L);
        Assert.assertEquals(expected, service.findById(1L));
    }

    @Test
    public void create() {
        Orders expected = new Orders();
        Orders orders = new Orders();
        Mockito.doReturn(expected)
                .when(repository)
                .save(orders);
        Assert.assertEquals(expected, service.create(orders));
    }

    @Test
    public void delete() {
        Mockito.doReturn(Optional.of(new Orders()))
                .when(repository)
                .findById(1L);
        Assert.assertTrue(service.delete(1L));
    }

    @Test
    public void update() {
        Mockito.doReturn(Optional.of(new Orders()))
                .when(repository)
                .findById(1L);
        Assert.assertTrue(service.update(new Orders(), 1L));
    }
}
