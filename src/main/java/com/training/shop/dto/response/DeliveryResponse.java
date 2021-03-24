package com.training.shop.dto.response;

import com.training.shop.model.Address;
import com.training.shop.model.Cargo;
import com.training.shop.model.Client;
import com.training.shop.model.DeliveryStatus;
import com.training.shop.model.Shop;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * An object for transferring data from a controller to a response about delivery.
 */
@Data
@Builder
public class DeliveryResponse {

    /**
     * Information about the client's desire to receive notifications
     */
    private final Boolean enabledNotifications;

    /**
     * Cost of delivery
     */
    private final BigDecimal sum;

    /**
     * Unique delivery number
     */
    private final String trackingNumber;

    /**
     * Information about payment for cargo transit
     */
    private final Boolean paid;

    /**
     * Information about the delivery stage (cargo status)
     */
    private final DeliveryStatus status;

    /**
     * Cargo information
     */
    private final Cargo cargo;

    /**
     * Information about the sender
     */
    private final Shop shop;

    /**
     * Information about the recipient
     */
    private final Client client;

    /**
     * Sending address
     */
    private final Address sendingAddress;

    /**
     * Shipping address
     */
    private final Address shippingAddress;

    /**
     * Time of object creation
     */
    @CreationTimestamp
    private final LocalDateTime created;

    /**
     * Update time
     */
    @UpdateTimestamp
    private final LocalDateTime updated;
}
