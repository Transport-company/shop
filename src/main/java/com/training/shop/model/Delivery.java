package com.training.shop.model;

import lombok.Data;

import javax.persistence.*;

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
     * Cargo information
     */
    @OneToOne(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    @JoinColumn(name = "cargo_id", referencedColumnName = "id")
    private Cargo cargo;

    /**
     * Cargo status
     */
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
}
