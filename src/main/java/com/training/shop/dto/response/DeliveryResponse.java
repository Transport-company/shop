package com.training.shop.dto.response;

import com.training.shop.model.Address;
import com.training.shop.model.Cargo;
import com.training.shop.model.Client;
import com.training.shop.model.DeliveryStatus;
import com.training.shop.model.Shop;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * An object for transferring data from a controller to a response about delivery.
 */
@Data
public class DeliveryResponse {

    /**
     * Information about the client's desire to receive notifications
     */
    private Boolean enabledNotifications;

    /**
     * Cost of delivery
     */
    private BigDecimal sum;

    /**
     * Unique delivery number
     */
    private String trackingNumber;

    /**
     * Information about payment for cargo transit
     */
    private Boolean isPaid;

    /**
     * Information about the delivery stage (cargo status)
     */
    private DeliveryStatus status;

    /**
     * Cargo information
     */
    private Cargo cargo;

    /**
     * Information about the sender
     */
    private Shop shop;

    /**
     * Information about the recipient
     */
    private Client client;

    /**
     * Sending address
     */
    private Address sendingAddress;

    /**
     * Shipping address
     */
    private Address shippingAddress;

    /**
     * Time of object creation
     */
    @CreationTimestamp
    private LocalDateTime created;

    /**
     * Update time
     */
    @UpdateTimestamp
    private LocalDateTime updated;
}
