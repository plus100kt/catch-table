package com.echo.catchtable.dto.service;

import com.echo.catchtable.domain.Shop;
import com.echo.catchtable.dto.OpenWeek;
import com.echo.catchtable.dto.request.ShopReservation;
import com.echo.catchtable.dto.request.ShopWaiting;
import com.echo.catchtable.enums.ShopStatus;
import com.echo.catchtable.enums.ShopType;
import lombok.Builder;

import java.util.List;

public record ShopSaveService (
        Long sellerId,
        String name,
        ShopType type,
        String description,
        String mainImage,
        String address,
        String addressDetail,
        String phone,
        List<OpenWeek> openWeeks,
        ShopWaiting waiting,
        ShopReservation reservation
){
    public Shop toEntity() {
        return Shop.builder()
                .sellerId(sellerId)
                .name(name).type(type)
                .description(description)
                .status(ShopStatus.AVAILABLE)
                .mainImage(mainImage)
                .address(address)
                .addressDetail(addressDetail)
                .phone(phone)
                .openWeeks(openWeeks)
                .build();
    }
}
