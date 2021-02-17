package com.training.shop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity for cargo
 */
@Entity
@Table(name = "cargo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cargo {

    /**
     * Unique identifier of the cargo
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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