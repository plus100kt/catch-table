package com.echo.catchtable.service;

import com.echo.catchtable.domain.ReservationInformation;
import com.echo.catchtable.domain.Shop;
import com.echo.catchtable.domain.WaitingInformation;
import com.echo.catchtable.dto.request.ShopSaveRequest;
import com.echo.catchtable.dto.service.ShopDetail;
import com.echo.catchtable.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ShopService {
    private final ShopRepository shopRepository;
    private final WaitingInformationService wInfoService;
    private final ReservationInformationService rInfoService;

    @Transactional
    public ShopDetail save(ShopSaveRequest request) {
        Shop shop = shopRepository.save(request.toEntity());
        WaitingInformation wInfo = wInfoService.save(request.waiting().toEntity(shop.getId()));
        ReservationInformation rInfo = rInfoService.save(request.reservation().toEntity(shop.getId()));

        return new ShopDetail(shop, wInfo, rInfo);
    }
}
