package com.echo.catchtable.controller;

import com.echo.catchtable.dto.request.ShopSaveRequest;
import com.echo.catchtable.dto.response.ShopDetailResponse;
import com.echo.catchtable.dto.service.ShopDetail;
import com.echo.catchtable.service.ShopService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ShopController {
    private final ShopService shopService;

    @PostMapping("/shops")
    public ResponseEntity<ShopDetailResponse> saveShop(@RequestBody @Valid ShopSaveRequest request) {
        ShopDetail shopDetail = shopService.save(request);
        ShopDetailResponse response =  new ShopDetailResponse(shopDetail);

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(response);
    }
}
