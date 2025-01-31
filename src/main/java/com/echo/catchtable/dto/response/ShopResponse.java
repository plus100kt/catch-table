package com.echo.catchtable.dto.response;

import com.echo.catchtable.domain.ReservationInformation;
import com.echo.catchtable.domain.Shop;
import com.echo.catchtable.domain.WaitingInformation;

import java.time.LocalDateTime;

public record ShopResponse (
    Long id,
    Long seller_id,
    String name,
    String type,
    String description,
    String main_image,
    String address,
    String address_detail,
    String phone,
    String open_week,

    String waiting_status,
    String waiting,

    String reservation_status,
    String reservation,

    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
    public ShopResponse(Shop shop, WaitingInformation wInfo, ReservationInformation rInfo) {
        this(
                shop.getId(),
                shop.getSeller_id(),
                shop.getName(),
                shop.getType(),
                shop.getDescription(),
                shop.getMain_image(),
                shop.getAddress(),
                shop.getAddress_detail(),
                shop.getPhone(),
                shop.getOpen_week(),
                // 수정예정
                wInfo.getStatus(),
                wInfo.toString(),
                // 수정예정
                rInfo.getStatus(),
                rInfo.toString(),

                shop.getCreatedAt(),
                shop.getUpdatedAt()
        );
    }
}
