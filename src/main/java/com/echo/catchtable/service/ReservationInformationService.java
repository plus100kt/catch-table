package com.echo.catchtable.service;

import com.echo.catchtable.domain.ReservationInformation;
import com.echo.catchtable.repository.ReservationInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReservationInformationService {
    private final ReservationInformationRepository rInfoRepository;

    public ReservationInformation save(ReservationInformation rInfo) {
        return rInfoRepository.save(rInfo);
    }
}
