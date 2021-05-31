package com.teplov.controller;

import com.teplov.entity.Payment;
import com.teplov.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Контроллер для класса {@link Payment}
 */
@RestController
public class PaymentController {

    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    /**
     * Получение списка способов оплаты
     *
     * @return OK (весь список способов оплаты) и NOT_FOUND, если список пуст
     */
    @GetMapping(value = "/payments")
    public ResponseEntity<List<Payment>> getPayments() {
        List<Payment> payments = paymentService.findAll();
        if (payments != null && !payments.isEmpty())
            return new ResponseEntity<>(payments, HttpStatus.OK);

        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
