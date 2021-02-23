package com.training.shop.dto.reqest;

import com.training.shop.model.Address;
import com.training.shop.model.Client;
import com.training.shop.model.DeliveryStatus;
import com.training.shop.model.Shop;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * An object for transferring data from a request to a controller about a delivery.
 */
@Data
public class DeliveryRequest {

    /**
     * Information about the client's desire to receive notifications
     */
    private Boolean enabledNotifications;

    /**
     * Unique delivery number
     */
    private String trackingNumber;

    /**
     * Information about payment for cargo transit
     */
    private Boolean isPaid;

    /**
     * Shipping address
     */
    private Address shippingAddress;

    /**
     * Information about the recipient
     */
    private Client client;

    /**
     * Information about the shop-sender
     */
    private Shop shop;

    /**
     * Information about the delivery stage (cargo status)
     */
    private DeliveryStatus status;

    /**
     * Time of object creation
     */
    private LocalDateTime created;

    /**
     * Update time
     */
    private LocalDateTime updated;
}
