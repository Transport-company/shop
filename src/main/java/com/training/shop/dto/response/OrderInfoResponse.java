package com.training.shop.dto.response;

import com.training.shop.controller.model.DeliveryStatus;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

/**
 * An object for transferring data from a controller to a response about an order info.
 */
@Schema(description = "Response for order info request")
public class OrderInfoResponse {


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
