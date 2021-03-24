package com.training.shop.dto.reqest;

import com.training.shop.model.Address;
import com.training.shop.model.Client;
import com.training.shop.model.DeliveryStatus;
import com.training.shop.model.Shop;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * An object for transferring data from a request to a controller about a delivery.
 */
@Data
@Builder
public class DeliveryRequest {

    /**
     * Information about the client's desire to receive notifications
     */
    @Schema(description = "to send or not send notifications to the client", required = true,
            example = "true")
    @NotNull(message = "The field is required")
    private final Boolean enabledNotifications;

    /**
     * Unique delivery number
     */
    @Schema(description = "a generated unique string", required = true,
            example = "mdu4n286ndgTwGGspr8hw5D7sErW5Mgcz")
    @Size(max = 30, message = "Max length is 30")
    private final String trackingNumber;

    /**
     * Information about payment for cargo transit
     */
    @Schema(description = "is the delivery paid for or not", required = true,
            example = "true")
    @NotNull(message = "The field is required")
    private final Boolean paid;

    /**
     * Shipping address
     */
    @Schema(description = "an adress of receipt of the cargo", required = true)
    @NotNull(message = "The field is required")
    private final Address shippingAddress;

    /**
     * Information about the recipient
     */
    @Schema(description = "the recipient of the cargo", required = true)
    @NotNull(message = "The field is required")
    private final Client client;

    /**
     * Information about the shop-sender
     */
    @Schema(description = "an address of shop-sender from which the cargo is sent", required = true)
    @NotNull(message = "The field is required")
    private final Shop shop;

    /**
     * Information about the delivery stage (cargo status)
     */
    @Schema(description = "a delivery status", required = true,
            example = "REGISTERED")
    @NotNull(message = "The field is required")
    @Enumerated(EnumType.STRING)
    private final DeliveryStatus status;

    /**
     * Time of object creation
     */
    @Schema(description = "a date of delivery creation", required = true)
    @NotNull(message = "The field is required")
    private final LocalDateTime created;

    /**
     * Update time
     */
    @Schema(description = "a date of delivery update", required = true)
    @NotNull(message = "The field is required")
    private final LocalDateTime updated;
}
