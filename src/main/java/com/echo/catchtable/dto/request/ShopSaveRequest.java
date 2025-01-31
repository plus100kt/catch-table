package com.echo.catchtable.dto.request;

import com.echo.catchtable.domain.ReservationInformation;
import com.echo.catchtable.domain.Shop;
import com.echo.catchtable.domain.WaitingInformation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.Arrays;
import java.util.List;

public record ShopSaveRequest(
        @NotBlank(message = "아이디는 공백일 수 없습니다")
        Long seller_id,
        String name,

        // TODO: enum 으로 수정예정
        String type,
        String description,
        String main_image,
        String address,
        String address_detail,
        // TODO: Pattern 은 enum 으로 정리 예정
        @NotBlank
        @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호 양식이 다릅니다")
        String phone,
        OpenWeek[] open_week,

        String waiting_status,
        ShopWaiting waiting,

        String reservation_status,
        ShopReservation reservation
) {
    static ObjectMapper objectMapper = new ObjectMapper();

    public Shop toEntity() {
        List<String> openWeekStrList = Arrays.stream(open_week).map(weekInfo -> {
            try {
                return objectMapper.writeValueAsString(weekInfo);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }).toList();

        return Shop.builder()
                .seller_id(seller_id)
                .name(name).type(type)
                .description(description)
                .main_image(main_image)
                .address(address)
                .address_detail(address_detail)
                .phone(phone)
                .open_week(openWeekStrList.toString()).build();
    }

    public WaitingInformation toWaitingInformationEntity(long shop_id) {
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
                .waiting_max_count(waiting.waiting_max_count())
                .expected_time_per_person(waiting.expected_time_per_person())
                .status(waiting_status)
                .build();
    }

    public ReservationInformation toReservationInformationEntity(long shop_id) {
        // TODO: enum 으로 수정예정
        if (reservation_status.equals("이용불가")) {
            return ReservationInformation.builder()
                    .shop_id(shop_id)
                    .period(0)
                    .status(reservation_status)
                    .reservation_available_times("")
                    .build();
        }

        List<String> rTimeList = Arrays.stream(reservation.available_times()).map(time -> {
            try {
                return objectMapper.writeValueAsString(time);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }).toList();

        return ReservationInformation.builder()
                .shop_id(shop_id)
                .period(reservation.period())
                .status(reservation_status)
                .reservation_available_times(rTimeList.toString())
                .build();
    }
}
