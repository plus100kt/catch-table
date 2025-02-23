package com.echo.catchtable.domain;

import com.echo.catchtable.dto.OpenWeek;
import com.echo.catchtable.enums.ShopStatus;
import com.echo.catchtable.enums.ShopType;
import com.echo.catchtable.utils.OpenWeeksConverter;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Shop extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "seller_id", nullable = false)
    private Long sellerId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ShopType type;

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
    @Enumerated(EnumType.STRING)
    private ShopStatus status;

    @Lob
    @Column(name = "open_weeks", nullable = false)
    @Convert(converter = OpenWeeksConverter.class)
    private List<OpenWeek> openWeeks;

    @Builder
    public Shop(Long sellerId, String name, ShopType type, String description, String mainImage, String address, String addressDetail, String phone, ShopStatus status, List<OpenWeek> openWeeks) {
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
