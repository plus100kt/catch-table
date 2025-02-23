package com.echo.catchtable.dto.request;

import com.echo.catchtable.domain.ReservationInformation;
import com.echo.catchtable.dto.AvailableTime;
import com.echo.catchtable.enums.ReservationStatus;
import com.echo.catchtable.utils.AvailableTimesConverter;
import jakarta.persistence.Convert;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ShopReservation (
        @NotNull(message = "상태는 Null 일 수 없습니다")
        ReservationStatus status,
        @NotNull(message = "기간은 Null 일 수 없습니다")
        Integer period,
        @Convert(converter = AvailableTimesConverter.class)
        List<AvailableTime> availableTimes
) {

    public ReservationInformation toEntity(long shopId) {
        return ReservationInformation.builder()
                .shopId(shopId)
                .period(period)
                .status(status)
                .availableTimes(availableTimes)
                .build();
    }
}
