package com.echo.catchtable.dto.service;

import com.echo.catchtable.domain.ReservationInformation;
import com.echo.catchtable.domain.Shop;
import com.echo.catchtable.domain.WaitingInformation;


public record ShopDetailService(
    Shop shop,
    WaitingInformation waitingInformation,
    ReservationInformation reservationInformation
) {
}