package com.echo.catchtable.dto.request;

import com.echo.catchtable.domain.WaitingInformation;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ShopWaiting (
        int waiting_max_count,
        int expected_time_per_person
){
    public WaitingInformation toEntity(long shop_id, String waiting_status) {
        // TODO: enum 으로 수정예정
        if (waiting_status.equals("이용불가")) {
            return WaitingInformation.builder()
                    .shop_id(shop_id)
                    .waiting_max_count(0)
                    .expected_time_per_person(0)
                    .status(waiting_status)
                    .build();
        }
        return WaitingInformation.builder()
                .shop_id(shop_id)
                .waiting_max_count(waiting_max_count())
                .expected_time_per_person(expected_time_per_person())
                .status(waiting_status)
                .build();
    }
}
