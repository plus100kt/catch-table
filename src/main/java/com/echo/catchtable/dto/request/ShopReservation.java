package com.echo.catchtable.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ShopReservation (
        Integer period,
        ReservationTime[] available_times
) {
}
