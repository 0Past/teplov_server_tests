package com.teplov.service;

import com.teplov.entity.DeliveryType;
import com.teplov.repository.DeliveryTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис для класса {@link DeliveryType}
 */
@Service
public class DeliveryTypeService {

    private DeliveryTypeRepository deliveryTypeRepository;

    @Autowired
    public DeliveryTypeService(DeliveryTypeRepository deliveryTypeRepository) {
        this.deliveryTypeRepository = deliveryTypeRepository;
    }
    /**
     * Получние всех записей по способам доставки
     * @return все покупатели
     */
    public List<DeliveryType> findAll() {
        return deliveryTypeRepository.findAll();
    }

}
