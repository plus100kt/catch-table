package com.echo.catchtable.service;

import com.echo.catchtable.domain.ReservationInformation;
import com.echo.catchtable.repository.ReservationInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReservationInfoService {
    private final ReservationInformationRepository rInfoRepository;

    public ReservationInformation findById(long id) {
        return rInfoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));
    }
}
