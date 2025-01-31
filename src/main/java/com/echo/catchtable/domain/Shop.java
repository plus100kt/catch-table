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
    private Long sellerId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "main_image", nullable = false)
    private String mainImage;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "address_detail", nullable = false)
    private String addressDetail;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "status", nullable = false)
    private String status;

    @Lob
    @Column(name = "open_weeks", nullable = false)
    private String openWeeks;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Builder
    public Shop(Long sellerId, String name, String type, String description, String mainImage, String address, String addressDetail, String phone, String status, String openWeeks) {
        this.sellerId = sellerId;
        this.name = name;
        this.type = type;
        this.description = description;
        this.mainImage = mainImage;
        this.address = address;
        this.addressDetail = addressDetail;
        this.phone = phone;
        this.status = status;
        this.openWeeks = openWeeks;
    }
}
