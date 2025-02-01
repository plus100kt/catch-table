package com.echo.catchtable.controller;

import com.echo.catchtable.domain.Shop;
import com.echo.catchtable.dto.OpenWeek;
import com.echo.catchtable.dto.request.ShopSaveRequest;
import com.echo.catchtable.dto.request.ShopUpdateRequest;
import com.echo.catchtable.dto.response.ShopDetailResponse;
import com.echo.catchtable.dto.response.ShopResponse;
import com.echo.catchtable.service.ShopService;
import com.echo.catchtable.util.JsonHelper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ShopController {
    private final ShopService shopService;

    @PostMapping("/shops")
    public ResponseEntity<ShopDetailResponse> saveShop(@RequestBody @Valid ShopSaveRequest request) throws Exception {
        ShopDetailResponse savedShop = shopService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(savedShop);
    }

    @PutMapping ("/shops/{id}")
    public ResponseEntity<ShopResponse> updateShop(@PathVariable long id, @RequestBody @Valid ShopUpdateRequest request) throws Exception {
        Shop savedShop = shopService.update(id, request);

        JsonHelper jsonHelper = JsonHelper.getInstance();
        OpenWeek[] openWeeks = jsonHelper.readValue(savedShop.getOpenWeeks(), OpenWeek[].class);

        return ResponseEntity.ok()
                .body(new ShopResponse(savedShop, openWeeks));
    }
}
