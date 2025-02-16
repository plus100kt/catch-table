package com.echo.catchtable.dto.request;

import com.echo.catchtable.domain.WaitingInformation;
import com.echo.catchtable.enums.WaitingStatus;
import jakarta.validation.constraints.NotNull;

public record ShopWaiting (
        @NotNull(message = "상태는 Null 일 수 없습니다")
        WaitingStatus status,
        @NotNull(message = "최대인원는 Null 일 수 없습니다")
        Integer waitingMaxCount,
        @NotNull(message = "기다리는 시간은 Null 일 수 없습니다")
        Integer expectedTimePerPerson
){
    public WaitingInformation toEntity(long shopId) {
        return WaitingInformation.builder()
                .shopId(shopId)
                .waitingMaxCount(waitingMaxCount)
                .expectedTimePerPerson(expectedTimePerPerson)
                .status(status)
                .build();
    }
}
