package com.teplov.service;

import com.teplov.entity.Payment;
import com.teplov.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Сервис для класса {@link Payment}
 */
@Service
public class PaymentService {

    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
    /**
     * Получние всех записей из способа оплаты
     * @return все способы оплаты
     */
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

}
