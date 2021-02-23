package com.training.shop.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity about product
 */
@Entity
@Table(name = "product")
@Data
public class Product {

    /**
     * Unique identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Item name
     */
    @Column(name = "name")
    private String name;

    /**
     * Price of a one item
     */
    @Column(name = "price")
    private BigDecimal price;

    /**
     * Weight of one item
     */
    @Column(name = "weight")
    private Float weight;

    /**
     * Length of one item
     */
    @Column(name = "length")
    private Float length;

    /**
     * Width of one item
     */
    @Column(name = "width")
    private Float width;

    /**
     * Height of one item
     */
    @Column(name = "height")
    private Float height;

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