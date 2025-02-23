package com.echo.catchtable.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ShopType {
    JAPANESE_FOOD("일식"),
    CHINESE_FOOD("중국"),
    WESTERN_FOOD("양식"),
    KOREAN_FOOD("한식");

    private final String description;
}
