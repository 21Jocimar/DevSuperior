package com.devsuperior.aula.services;

import com.devsuperior.aula.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment(Order order) {
        double freight = 0.0;
        Double basic = order.getBasic();

        if (basic < 100.0) {
            freight = 20.0;
        } else if (basic < 200.0) {
            freight = 12.0;
        }

        return freight;
    }
}
