package com.teplov.service;

import com.teplov.entity.Category;
import com.teplov.entity.Item;
import com.teplov.entity.OrderedItem;
import com.teplov.entity.Orders;
import com.teplov.repository.ItemRepository;
import com.teplov.repository.OrderedItemRepository;
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
public class ItemServiceTest {

    @Autowired
    private ItemService service;

    @MockBean
    private ItemRepository repository;

    @MockBean
    private OrderedItemRepository orderedItemRepository;

    @Test
    public void findAll() {
        ArrayList<Item> expected = new ArrayList<>();
        Item item = new Item();
        expected.add(item);
        Mockito.when(service.findAll()).thenReturn(expected);
        Assert.assertEquals(service.findAll(), expected);
    }

    @Test
    public void findById() {
        Optional<Item> expected = Optional.of(new Item());
        Mockito.doReturn(expected)
                .when(repository)
                .findById(1L);
        Assert.assertEquals(expected, service.findById(1L));
    }

    @Test
    public void findAllByCategoryId() {
        ArrayList<Item> expected = new ArrayList<>();
        Item item = new Item();
        item.setCategory(new Category());
        expected.add(item);
        Mockito.when(service.findAllByCategoryId(1L)).thenReturn(expected);
        Assert.assertEquals(service.findAllByCategoryId(1L), expected);
    }

    @Test
    public void findAllByOrderId() {
        ArrayList<OrderedItem> expected = new ArrayList<>();
        OrderedItem orderedItem = new OrderedItem();
        Item item = new Item();
        Orders orders = new Orders();
        orderedItem.setOrder(orders);
        orderedItem.setItem(item);
        expected.add(orderedItem);
        Mockito.when(orderedItemRepository.findByOrderId(1L)).thenReturn(expected);
        Assert.assertEquals(orderedItemRepository.findByOrderId(1L), expected);
    }

    @Test
    public void create() {
        Item expected = new Item();
        Item item = new Item();
        Mockito.doReturn(expected)
                .when(repository)
                .save(item);
        Assert.assertEquals(expected, service.create(item));
    }

    @Test
    public void delete() {
        Mockito.doReturn(Optional.of(new Item()))
                .when(repository)
                .findById(1L);
        Assert.assertTrue(service.delete(1L));
    }

    @Test
    public void update() {
        Mockito.doReturn(Optional.of(new Item()))
                .when(repository)
                .findById(1L);
        Assert.assertTrue(service.update(new Item(), 1L));
    }
}
