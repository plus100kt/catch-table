package com.echo.catchtable.dto.response;

import com.echo.catchtable.domain.WaitingInformation;

public record ShopWaitingResponse (
        long id,
        long shop_id,
        String status,
        int waiting_max_count,
        int expected_time_per_person
) {
    public ShopWaitingResponse(WaitingInformation wInfo) {
        this(
                wInfo.getId(),
                wInfo.getShop_id(),
                wInfo.getStatus(),
                wInfo.getWaiting_max_count(),
                wInfo.getExpected_time_per_person()
        );
    }
}
