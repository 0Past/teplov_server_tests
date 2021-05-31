package com.teplov.controller;

import com.teplov.entity.DeliveryType;
import com.teplov.service.DeliveryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Контроллер для класса {@link DeliveryType}
 */
@RestController
public class DeliveryTypeController {

    private DeliveryTypeService deliveryTypeService;

    @Autowired
    public DeliveryTypeController(DeliveryTypeService deliveryTypeService) {
        this.deliveryTypeService = deliveryTypeService;
    }

    /**
     * Получение списка способа доставок
     * @return OK (весь список типов достаки) и NOT_FOUND, если список пуст
     */
    @GetMapping(value = "/delivery_types")
    public ResponseEntity<List<DeliveryType>> getDeliveryTypes() {
        List<DeliveryType> deliveryTypes = deliveryTypeService.findAll();
        if (deliveryTypes != null && !deliveryTypes.isEmpty())
            return new ResponseEntity<>(deliveryTypes, HttpStatus.OK);

        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
