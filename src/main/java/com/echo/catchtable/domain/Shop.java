package com.echo.catchtable.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "seller_id", nullable = false)
    private Long seller_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "main_image", nullable = false)
    private String main_image;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "address", nullable = false)
    private String address_detail;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "open_week", nullable = false)
    private String open_week;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Builder
    public Shop(Long seller_id, String name, String type, String description, String main_image, String address, String address_detail, String phone, String status, String open_week) {
        this.seller_id = seller_id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.main_image = main_image;
        this.address = address;
        this.address_detail = address_detail;
        this.phone = phone;
        this.status = status;
        this.open_week = open_week;
    }
}
