package com.echo.catchtable.dto.response;

import com.echo.catchtable.domain.Shop;
import com.echo.catchtable.dto.OpenWeek;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ShopDetailResponse(
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

    ShopWaitingResponse waiting,
    ShopReservationResponse reservation,

    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
    public ShopDetailResponse(ShopResponse shopResponse, OpenWeek[] openWeeks, ShopWaitingResponse waitingResponse, ShopReservationResponse reservationResponse) {
        this(
                shopResponse.id(),
                shopResponse.sellerId(),
                shopResponse.name(),
                shopResponse.status(),
                shopResponse.type(),
                shopResponse.description(),
                shopResponse.mainImage(),
                shopResponse.address(),
                shopResponse.addressDetail(),
                shopResponse.phone(),
                openWeeks,
                waitingResponse,
                reservationResponse,
                shopResponse.createdAt(),
                shopResponse.updatedAt()
        );
    }
}
