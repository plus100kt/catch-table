package com.echo.catchtable.dto.response;

import com.echo.catchtable.domain.WaitingInformation;
import com.echo.catchtable.enums.WaitingStatus;

public record ShopWaitingResponse (
        Long id,
        Long shop_id,
        WaitingStatus status,
        Integer waitingMaxCount,
        Integer expectedTimePerPerson
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
