package com.echo.catchtable.dto.request;

import com.echo.catchtable.domain.WaitingInformation;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ShopWaiting (
        int waitingMaxCount,
        int expectedTimePerPerson
){
    public WaitingInformation toEntity(long shop_id, String waiting_status) {
        // TODO: enum 으로 수정예정
        if (waiting_status.equals("이용불가")) {
            return WaitingInformation.builder()
                    .shopId(shop_id)
                    .waitingMaxCount(0)
                    .expectedTimePerPerson(0)
                    .status(waiting_status)
                    .build();
        }
        return WaitingInformation.builder()
                .shopId(shop_id)
                .waitingMaxCount(waitingMaxCount())
                .expectedTimePerPerson(expectedTimePerPerson())
                .status(waiting_status)
                .build();
    }
}
