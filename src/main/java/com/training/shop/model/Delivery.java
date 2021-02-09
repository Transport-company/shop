package com.training.shop.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Model for delivery
 */
@Entity
@Data
@Table(name = "delivery")
public class Delivery {

    /**
     * Unique identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Cost of delivery
     */
    @Column(name = "declared_value")
    private BigDecimal declaredValue;

    /**
     * Unique delivery number
     */
    @Column(name = "tracking_number")
    private String trackingNumber;

    /**
     * Cargo information
     */
    @OneToOne(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    @JoinColumn(name = "cargo_id", referencedColumnName = "id")
    private Cargo cargo;

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
     * Customer information
     */
    @OneToOne(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    /**
     * Cargo status
     */
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

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
