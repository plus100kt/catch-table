package com.echo.catchtable.service;

import com.echo.catchtable.domain.ReservationInformation;
import com.echo.catchtable.domain.Shop;
import com.echo.catchtable.domain.WaitingInformation;
import com.echo.catchtable.dto.AvailableTime;
import com.echo.catchtable.dto.OpenWeek;
import com.echo.catchtable.dto.request.ShopSaveRequest;
import com.echo.catchtable.dto.request.ShopUpdateRequest;
import com.echo.catchtable.dto.response.ShopReservationResponse;
import com.echo.catchtable.dto.response.ShopResponse;
import com.echo.catchtable.dto.response.ShopUpdateResponse;
import com.echo.catchtable.dto.response.ShopWaitingResponse;
import com.echo.catchtable.repository.ReservationInformationRepository;
import com.echo.catchtable.repository.ShopRepository;
import com.echo.catchtable.repository.WaitingInformationRepository;
import com.echo.catchtable.util.JsonHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ShopService {
    private final ShopRepository shopRepository;
    private final WaitingInformationRepository wInfoRepository;
    private final ReservationInformationRepository rInfoRepository;
    private final JsonHelper jsonHelper;

    @Transactional
    public ShopResponse save(ShopSaveRequest request) throws Exception {
        String openWeeksStr = jsonHelper.jsonArrayToString(request.openWeeks());
        String availableTimesStr = request.reservationStatus().equals("영업중지")
                ? ""
                :jsonHelper.jsonArrayToString(request.reservation().availableTimes());
        Shop shop = shopRepository.save(request.toEntity(openWeeksStr));
        OpenWeek[] openWeeks = jsonHelper.readValue(shop.getOpenWeeks(), OpenWeek[].class);
        // 비동기 가능하겠는데?
        WaitingInformation wInfo = wInfoRepository.save(request.waiting().toEntity(shop.getId(), request.waitingStatus()));
        ReservationInformation rInfo = rInfoRepository.save(request.reservation().toEntity(shop.getId(), request.reservationStatus(), availableTimesStr));
        AvailableTime[] ReservationTimes = jsonHelper.readValue(rInfo.getAvailableTimes(), AvailableTime[].class);

        ShopWaitingResponse wResponse = new ShopWaitingResponse(wInfo);
        ShopReservationResponse rResponse = new ShopReservationResponse(rInfo, ReservationTimes);

        ShopResponse response = new ShopResponse(shop, openWeeks, wResponse, rResponse);
        return response;
    }

    @Transactional
    public ShopUpdateResponse update(long id, ShopUpdateRequest request) throws Exception {
        String openWeeksStr = jsonHelper.jsonArrayToString(request.openWeeks());
        Shop shop = shopRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));
        shop.update(request, openWeeksStr);
        OpenWeek[] openWeeks = jsonHelper.readValue(shop.getOpenWeeks(), OpenWeek[].class);
        ShopUpdateResponse response = new ShopUpdateResponse(shop, openWeeks);
        return response;
    }
}
