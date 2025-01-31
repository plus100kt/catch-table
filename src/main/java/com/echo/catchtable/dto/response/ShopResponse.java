package com.echo.catchtable.dto.response;

import com.echo.catchtable.domain.Shop;
import com.echo.catchtable.dto.OpenWeek;

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
    OpenWeek[] open_weeks,

    ShopWaitingResponse waiting,
    ShopReservationResponse reservation,

    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
    public ShopResponse(Shop shop, OpenWeek[] openWeeks, ShopWaitingResponse waitingResponse, ShopReservationResponse reservationResponse) {
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
                openWeeks,
                waitingResponse,
                reservationResponse,
                shop.getCreatedAt(),
                shop.getUpdatedAt()
        );
    }
}
