package com.training.shop.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity for order
 */
@Entity
@Table(name = "orders")
@Data
public class Order {

    /**
     * Unique identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Unique order number
     */
    @Column(name = "order_number")
    private BigDecimal orderNumber;

    /**
     * Information about customer
     */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

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
