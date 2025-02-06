package com.echo.catchtable.service;

import com.echo.catchtable.domain.WaitingInformation;
import com.echo.catchtable.repository.WaitingInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WaitingInfoService {
    private final WaitingInformationRepository wInfoRepository;

    public WaitingInformation findById(long id) {
        return wInfoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));
    }
}
