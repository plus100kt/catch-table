package com.echo.catchtable.dto.response;

import com.echo.catchtable.domain.WaitingInformation;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ShopWaitingResponse (
        long id,
        long shop_id,
        String status,
        int waitingMaxCount,
        int expected_time_per_person
) {
    public ShopWaitingResponse(WaitingInformation wInfo) {
        this(
                wInfo.getId(),
                wInfo.getShopId(),
                wInfo.getStatus(),
                wInfo.getWaitingMaxCount(),
                wInfo.getExpectedTimePerPerson()
        );
    }
}
