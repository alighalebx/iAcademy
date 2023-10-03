package com.example.iacdemy.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(name = "created at", updatable = false, nullable = false)
    private Instant createAt;

    @UpdateTimestamp
    @Column(name = "updated at", nullable = false)
    private Instant updateAt;

    @Version
    private Integer version;
}
