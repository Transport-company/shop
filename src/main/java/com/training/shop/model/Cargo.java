package com.training.shop.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Model for cargo
 */

@Entity
@Table(name = "cargo")
@Data
public class Cargo {

    /**
     * Unique identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Cargo code for inside use
     */
    @Column(name = "number")
    private BigDecimal number;

    /**
     * Weight of the cargo
     */
    @Column(name = "weight")
    private Float weight;

    /**
     * Price of the cargo
     */
    @Column(name = "declared_value")
    private BigDecimal declaredValue;

    /**
     * Cargo packing length
     */
    @Column(name = "length")
    private Float length;

    /**
     * Cargo packing width
     */
    @Column(name = "width")
    private Float width;

    /**
     * Cargo packing height
     */
    @Column(name = "height")
    private Float height;

    /**
     * Information about shop-seller
     */
    @OneToOne(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    @JoinColumn(name = "shop_id", referencedColumnName = "id")
    private Shop shop;

    /**
     * Sender shop info
     */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

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
