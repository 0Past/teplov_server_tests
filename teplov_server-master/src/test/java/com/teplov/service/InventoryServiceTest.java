package com.teplov.service;

import com.teplov.entity.Category;
import com.teplov.entity.Inventory;
import com.teplov.entity.Item;
import com.teplov.repository.InventoryRepository;
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
public class InventoryServiceTest {

    @Autowired
    private InventoryService service;

    @MockBean
    private InventoryRepository repository;

    @Test
    public void findAll() {
        ArrayList<Inventory> expected = new ArrayList<>();
        Inventory inventory = new Inventory();
        expected.add(inventory);
        Mockito.when(service.findAll()).thenReturn(expected);
        Assert.assertEquals(service.findAll(), expected);
    }

    @Test
    public void findById() {
        Optional<Inventory> expected = Optional.of(new Inventory());
        Mockito.doReturn(expected)
                .when(repository)
                .findById(1L);
        Assert.assertEquals(expected, service.findById(1L));
    }

    @Test
    public void create() {
        Inventory expected = new Inventory();
        Inventory inventory = new Inventory();
        Mockito.doReturn(expected)
                .when(repository)
                .save(inventory);
        Assert.assertEquals(expected, service.create(inventory));
    }

    @Test
    public void findByCategory() {
        ArrayList<Inventory> expected = new ArrayList<>();
        Inventory inventory = new Inventory();
        Item item = new Item();
        item.setCategory(new Category());
        inventory.setItem(item);
        expected.add(inventory);
        Mockito.when(service.findByCategory("Phones")).thenReturn(expected);
        Assert.assertEquals(service.findAll(), expected);
    }

    @Test
    public void delete() {
        Mockito.doReturn(Optional.of(new Inventory()))
                .when(repository)
                .findById(1L);
        Assert.assertTrue(service.delete(1L));
    }

    @Test
    public void update() {
        Mockito.doReturn(Optional.of(new Inventory()))
                .when(repository)
                .findById(1L);
        Assert.assertTrue(service.update(new Inventory(), 1L));
    }
}
