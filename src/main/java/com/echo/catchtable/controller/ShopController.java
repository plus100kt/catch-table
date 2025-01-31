package com.echo.catchtable.controller;

import com.echo.catchtable.domain.Shop;
import com.echo.catchtable.dto.request.ShopSaveRequest;
import com.echo.catchtable.dto.response.ShopResponse;
import com.echo.catchtable.service.ShopService;
import com.fasterxml.jackson.core.JsonProcessingException;
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
    public ResponseEntity<ShopResponse> saveShop(@RequestBody @Valid ShopSaveRequest request) throws Exception {
        ShopResponse savedShop = shopService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(savedShop);
    }
}
