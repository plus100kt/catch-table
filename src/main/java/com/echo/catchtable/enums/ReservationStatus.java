package com.echo.catchtable.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ReservationStatus {
    AVAILABLE("이용 가능"),
    UNAVAILABLE("이용 불가능"),
    SUSPENDED("일시 정지");

    private final String description;
}