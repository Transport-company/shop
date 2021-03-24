package com.training.shop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity for delivery of cargo
 */
@Entity
@Table(name = "delivery")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Delivery {

    /**
     * Unique identifier of the delivery
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Information about the client's desire to receive notifications
     */
    @Column(name = "enabled_notifications")
    private Boolean enabledNotifications;

    /**
     * Cost of delivery
     */
    @Column(name = "sum")
    private BigDecimal sum;

    /**
     * Unique delivery number
     */
    @Column(name = "tracking_number")
    @Size(max = 30)
    private String trackingNumber;

    /**
     * Information about payment for cargo transit
     */
    @Column(name = "paid")
    private Boolean paid;

    /**
     * Information about the delivery stage (cargo status)
     */
    @Column(name = "status")
    @Size(max = 10)
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    /**
     * Cargo information
     */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cargo_id", referencedColumnName = "id")
    private Cargo cargo;

    /**
     * Information about the sender
     */
    @ManyToOne(fetch = FetchType.EAGER, optional = false, targetEntity = Shop.class)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    /**
     * Information about the recipient
     */
    @ManyToOne(fetch = FetchType.EAGER, optional = false, targetEntity = Client.class)
    @JoinColumn(name = "customer_id")
    private Client client;

    /**
     * Sending address
     */
    @ManyToOne(fetch = FetchType.EAGER, optional = false, targetEntity = Address.class)
    @JoinColumn(name = "sending_address_id")
    private Address sendingAddress;

    /**
     * Shipping address
     */
    @ManyToOne(fetch = FetchType.EAGER, optional = false, targetEntity = Address.class)
    @JoinColumn(name = "shipping_address_id")
    private Address shippingAddress;

    /**
     * Time of object creation
     */
    @CreationTimestamp
    @Column(name = "created")
    private LocalDateTime created;

    /**
     * Update time
     */
    @UpdateTimestamp
    @Column(name = "updated")
    private LocalDateTime updated;
}