package com.teplov.service;

import com.teplov.entity.Inventory;
import com.teplov.entity.Payment;
import com.teplov.repository.PaymentRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentServiceTest {

    @Autowired
    private PaymentService service;

    @MockBean
    private PaymentRepository repository;

    @Test
    public void findAll() {
        ArrayList<Payment> expected = new ArrayList<>();
        Payment payment = new Payment();
        expected.add(payment);
        Mockito.when(service.findAll()).thenReturn(expected);
        Assert.assertEquals(service.findAll(), expected);
    }
}
