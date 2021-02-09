package com.training.shop.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Entity for customer
 */
@Entity
@Table(name = "customer")
@Data
public class Customer {

    /**
     * Unique identifier of client
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The first name of the client
     */
    @Column(name = "name")
    private String name;

    /**
     * The second name of the client
     */
    @Column(name = "surname")
    private String surname;

    /**
     * The patronymic of the client
     */
    @Column(name = "patronymic")
    private String patronymic;

    /**
     * Date of birth
     */
    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    /**
     * The phone number of the client
     */
    @Column(name = "phone")
    private String phone;

    /**
     * The email of the client
     */
    @Column(name = "email")
    private String email;

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
