package com.echo.catchtable.dto.response;

import com.echo.catchtable.domain.Shop;
import com.echo.catchtable.dto.OpenWeek;

import java.time.LocalDateTime;

public record ShopUpdateResponse(
        Long id,
        Long sellerId,
        String name,
        String status,
        String type,
        String description,
        String mainImage,
        String address,
        String addressDetail,
        String phone,
        OpenWeek[] openWeeks,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
){
    public ShopUpdateResponse(Shop shop, OpenWeek[] openWeeks) {
        this(
                shop.getId(),
                shop.getSellerId(),
                shop.getName(),
                shop.getStatus(),
                shop.getType(),
                shop.getDescription(),
                shop.getMainImage(),
                shop.getAddress(),
                shop.getAddressDetail(),
                shop.getPhone(),
                openWeeks,
                shop.getCreatedAt(),
                shop.getUpdatedAt()
        );
    }
}
