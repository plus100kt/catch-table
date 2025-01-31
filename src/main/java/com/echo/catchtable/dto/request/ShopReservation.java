package com.echo.catchtable.dto.request;

import com.echo.catchtable.domain.ReservationInformation;
import com.echo.catchtable.dto.AvailableTime;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ShopReservation (
        Integer period,
        AvailableTime[] available_times
) {
    static ObjectMapper objectMapper = new ObjectMapper();

    public ReservationInformation toEntity(long shop_id, String status) {
        // TODO: enum 으로 수정예정
        if (status.equals("이용불가")) {
            return ReservationInformation.builder()
                    .shop_id(shop_id)
                    .period(0)
                    .status(status)
                    .reservation_available_times("")
                    .build();
        }

        List<String> rTimeList = Arrays.stream(available_times).map(time -> {
            try {
                return objectMapper.writeValueAsString(time);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }).toList();

        return ReservationInformation.builder()
                .shop_id(shop_id)
                .period(period)
                .status(status)
                .reservation_available_times(rTimeList.toString())
                .build();
    }
}
