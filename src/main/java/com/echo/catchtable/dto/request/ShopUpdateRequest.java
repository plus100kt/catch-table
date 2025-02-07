package com.echo.catchtable.dto.request;

import com.echo.catchtable.dto.OpenWeek;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ShopUpdateRequest (
        @NotNull(message = "아이디는 공백일 수 없습니다")
        Long sellerId,
        String name,
        // TODO: enum 으로 수정예정
        String type,
        String status,
        String description,
        String mainImage,
        String address,
        String addressDetail,
        // TODO: Pattern 은 enum 으로 정리 예정
        @NotBlank
        @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호 양식이 다릅니다")
        String phone,
        OpenWeek[] openWeeks
) {

}
