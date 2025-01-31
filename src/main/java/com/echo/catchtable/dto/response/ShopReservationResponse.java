package com.echo.catchtable.dto.response;

import com.echo.catchtable.domain.ReservationInformation;
import com.echo.catchtable.dto.AvailableTime;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ShopReservationResponse (
        long id,
        long shopId,
        String status,
        int period,
        AvailableTime[] availableTimes
) {
    public ShopReservationResponse(ReservationInformation rInfo, AvailableTime[] times) {
        this(
                rInfo.getId(),
                rInfo.getShopId(),
                rInfo.getStatus(),
                rInfo.getPeriod(),
                times
        );
    }
}
