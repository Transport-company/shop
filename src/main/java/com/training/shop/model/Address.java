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
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * Entity for address
 */
@Entity
@Table(name = "address")
@Data
public class Address {

    /**
     * Unique identifier of the address
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Subject of the country of sending or delivery
     */
    @Column(name = "region")
    @Size(max = 128)
    private String region;

    /**
     * City of sending or delivery
     */
    @Column(name = "city")
    @Size(max = 128)
    private String city;

    /**
     * Street of sending or delivery
     */
    @Column(name = "street", nullable = false)
    @Size(max = 255)
    private String street;

    /**
     * House number of sending or delivery
     */
    @Column(name = "house")
    @Size(max = 16)
    private String house;

    /**
     * Flat number of sending or delivery
     */
    @Column(name = "apartment", nullable = false)
    @Size(max = 16)
    private String apartment;

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