package com.training.shop.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity for details for order
 */
@Entity
@Table(name = "order_details")
@Data
public class OrderDetails {

    /**
     * Unique identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Information about order
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false,
    referencedColumnName = "id")
    private Order order;

    /**
     * Information about item
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false,
            referencedColumnName = "id")
    private Item item;

    /**
     * Cost of order
     */
    @Column(name = "price")
    private Float price;

    /**
     * Amount of items of one type
     */
    @Column(name = "amount")
    private BigDecimal amount;

    /**
     * Amount of types of item in order
     */
    @Column(name = "quantity")
    private BigDecimal quantity;

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
