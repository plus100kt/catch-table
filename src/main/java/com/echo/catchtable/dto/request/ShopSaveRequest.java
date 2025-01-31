package com.echo.catchtable.dto.request;

import com.echo.catchtable.domain.Shop;
import com.echo.catchtable.dto.OpenWeek;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Arrays;
import java.util.List;

public record ShopSaveRequest(
        @NotNull(message = "아이디는 공백일 수 없습니다")
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
        OpenWeek[] open_weeks,

        String waiting_status,
        ShopWaiting waiting,

        String reservation_status,
        ShopReservation reservation
) {
    static ObjectMapper objectMapper = new ObjectMapper();

    public Shop toEntity() {
        List<String> openWeekStrList = Arrays.stream(open_weeks).map(weekInfo -> {
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
                .status("영업중")
                .main_image(main_image)
                .address(address)
                .address_detail(address_detail)
                .phone(phone)
                .open_week(openWeekStrList.toString()).build();
    }
}
