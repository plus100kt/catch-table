package com.echo.catchtable.dto.request;

import com.echo.catchtable.domain.ReservationInformation;
import com.echo.catchtable.dto.AvailableTime;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ShopReservation (
        int period,
        AvailableTime[] availableTimes
) {
    public ReservationInformation toEntity(long shop_id, String status, String availableTimes) {
        // TODO: enum 으로 수정예정
        if (status.equals("이용불가")) {
            return ReservationInformation.builder()
                    .shopId(shop_id)
                    .period(0)
                    .status(status)
                    .availableTimes("")
                    .build();
        }

        return ReservationInformation.builder()
                .shopId(shop_id)
                .period(period)
                .status(status)
                .availableTimes(availableTimes)
                .build();
    }
}
