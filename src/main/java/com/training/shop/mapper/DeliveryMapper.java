package com.training.shop.mapper;


import com.training.shop.dto.response.DeliveryResponse;
import com.training.shop.model.Delivery;
import org.springframework.stereotype.Component;

@Component
public class DeliveryMapper {

    public Delivery toDeliveryResponse(DeliveryResponse deliveryResponse){
        return Delivery.builder()
                .enabledNotifications(deliveryResponse.getEnabledNotifications())
                .sum(deliveryResponse.getSum())
                .trackingNumber(deliveryResponse.getTrackingNumber())
                .paid(deliveryResponse.getPaid())
                .status(deliveryResponse.getStatus())
                .shop(deliveryResponse.getShop())
                .client(deliveryResponse.getClient())
                .sendingAddress(deliveryResponse.getSendingAddress())
                .shippingAddress(deliveryResponse.getShippingAddress())
                .created(deliveryResponse.getCreated())
                .updated(deliveryResponse.getUpdated())
                .build();
    }
}
