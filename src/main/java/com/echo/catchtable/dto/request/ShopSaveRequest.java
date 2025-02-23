package com.echo.catchtable.dto.request;

import com.echo.catchtable.domain.Shop;
import com.echo.catchtable.dto.OpenWeek;
import com.echo.catchtable.dto.service.ShopSaveServiceDto;
import com.echo.catchtable.enums.ShopStatus;
import com.echo.catchtable.enums.ShopType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

public record ShopSaveRequest(
        @NotNull(message = "아이디는 Null 일 수 없습니다")
        Long sellerId,
        @NotBlank(message = "이름은 공백일 수 없습니다")
        @Size(min = 1, max = 10, message = "이름은 1 ~ 10자 이여야 합니다!")
        String name,
        @NotNull(message = "유형은 Null 일 수 없습니다")
        ShopType type,
        @NotBlank(message = "설명은 공백일 수 없습니다")
        String description,
        @NotBlank(message = "이미지는 공백일 수 없습니다")
        String mainImage,
        @NotBlank(message = "주소는 공백일 수 없습니다")
        String address,
        @NotBlank(message = "상세주소는 공백일 수 없습니다")
        String addressDetail,
        // TODO: Pattern 은 enum 으로 정리 예정
        @NotBlank(message = "핸드폰 번호는 공백일 수 없습니다")
        @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호 양식이 다릅니다")
        String phone,
        @NotNull(message = "오픈요일은 null일 수 없습니다")
        List<OpenWeek> openWeeks,

        @NotNull(message = "웨이팅정보는 null일 수 없습니다")
        ShopWaiting waiting,
        @NotNull(message = "예약정보는 null일 수 없습니다")
        ShopReservation reservation
) {
        public ShopSaveServiceDto toService() {
                return new ShopSaveServiceDto(
                        sellerId,
                        name,
                        type,
                        description,
                        mainImage,
                        address,
                        addressDetail,
                        phone,
                        openWeeks,
                        waiting,
                        reservation
                );
        }

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
