package com.teplov.service;

import com.teplov.entity.DeliveryType;
import com.teplov.repository.DeliveryTypeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeliveryTypeServiceTest {

    @Autowired
    private DeliveryTypeService service;

    @MockBean
    private DeliveryTypeRepository repository;

    @Test
    public void findAll() {
        ArrayList<DeliveryType> expected = new ArrayList<>();
        DeliveryType deliveryType = new DeliveryType();
        expected.add(deliveryType);
        Mockito.when(service.findAll()).thenReturn(expected);
        Assert.assertEquals(service.findAll(), expected);
    }
}
