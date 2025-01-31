package com.echo.catchtable.dto.response;

import com.echo.catchtable.domain.ReservationInformation;
import com.echo.catchtable.dto.AvailableTime;

public record ShopReservationResponse (
        long id,
        long shop_id,
        String status,
        int period,
        AvailableTime[] available_times
) {
    public ShopReservationResponse(ReservationInformation rInfo, AvailableTime[] times) {
        this(
                rInfo.getId(),
                rInfo.getShop_id(),
                rInfo.getStatus(),
                rInfo.getPeriod(),
                times
        );
    }
}
