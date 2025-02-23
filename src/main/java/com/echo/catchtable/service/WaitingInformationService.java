package com.echo.catchtable.service;

import com.echo.catchtable.domain.WaitingInformation;
import com.echo.catchtable.repository.WaitingInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WaitingInformationService {
    private final WaitingInformationRepository wInfoRepository;

    public WaitingInformation save(WaitingInformation wInfo) {
        return wInfoRepository.save(wInfo);
    }
}
