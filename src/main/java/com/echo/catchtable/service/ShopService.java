package com.echo.catchtable.service;

import com.echo.catchtable.domain.ReservationInformation;
import com.echo.catchtable.domain.Shop;
import com.echo.catchtable.domain.WaitingInformation;
import com.echo.catchtable.dto.service.ShopDetailServiceDto;
import com.echo.catchtable.dto.service.ShopSaveServiceDto;
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
    public ShopDetailServiceDto save(ShopSaveServiceDto param) {
        Shop shop = shopRepository.save(param.toEntity());
        WaitingInformation wInfo = wInfoService.save(param.waiting().toEntity(shop.getId()));
        ReservationInformation rInfo = rInfoService.save(param.reservation().toEntity(shop.getId()));

        return new ShopDetailServiceDto(shop, wInfo, rInfo);
    }
}
