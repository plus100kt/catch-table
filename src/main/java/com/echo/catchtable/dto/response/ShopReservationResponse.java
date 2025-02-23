package com.echo.catchtable.dto.response;

import com.echo.catchtable.domain.ReservationInformation;
import com.echo.catchtable.dto.AvailableTime;
import com.echo.catchtable.enums.ReservationStatus;

import java.util.List;

public record ShopReservationResponse (
        Long id,
        Long shopId,
        ReservationStatus status,
        Integer period,
        List<AvailableTime> availableTimes
) {
    public ShopReservationResponse(ReservationInformation rInfo) {
        this(
                rInfo.getId(),
                rInfo.getShopId(),
                rInfo.getStatus(),
                rInfo.getPeriod(),
                rInfo.getAvailableTimes()
        );
    }
}
