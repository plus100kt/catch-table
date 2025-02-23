package com.echo.catchtable.dto.response;

import com.echo.catchtable.dto.OpenWeek;
import com.echo.catchtable.dto.service.ShopDetail;
import com.echo.catchtable.enums.ShopStatus;
import com.echo.catchtable.enums.ShopType;

import java.time.LocalDateTime;
import java.util.List;

public record ShopDetailResponse(
    Long id,
    Long sellerId,
    String name,
    ShopStatus status,
    ShopType type,
    String description,
    String mainImage,
    String address,
    String addressDetail,
    String phone,
    List<OpenWeek> openWeeks,

    ShopWaitingResponse waiting,
    ShopReservationResponse reservation
) {
    public ShopDetailResponse(ShopDetail detail) {
        this(
                detail.shop().getId(),
                detail.shop().getSellerId(),
                detail.shop().getName(),
                detail.shop().getStatus(),
                detail.shop().getType(),
                detail.shop().getDescription(),
                detail.shop().getMainImage(),
                detail.shop().getAddress(),
                detail.shop().getAddressDetail(),
                detail.shop().getPhone(),
                detail.shop().getOpenWeeks(),
                new ShopWaitingResponse(detail.waitingInformation()),
                new ShopReservationResponse(detail.reservationInformation())
        );
    }
}
