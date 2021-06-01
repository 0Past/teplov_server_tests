package com.teplov.service;

import com.teplov.entity.OrderedItem;
import com.teplov.repository.OrderedItemRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderedItemServiceTest {

    @Autowired
    private OrderedItemService service;

    @MockBean
    private OrderedItemRepository repository;

    @Test
    public void addItems() {
        OrderedItem orderedItem1 = new OrderedItem();
        OrderedItem orderedItem2 = new OrderedItem();
        ArrayList<OrderedItem> orderedItems = new ArrayList<>();
        orderedItems.add(orderedItem1);
        orderedItems.add(orderedItem2);
        Assert.assertTrue(service.addItems(orderedItems));
    }
}
