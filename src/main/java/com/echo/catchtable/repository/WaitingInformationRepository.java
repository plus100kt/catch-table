package com.echo.catchtable.repository;

import com.echo.catchtable.domain.WaitingInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WaitingInformationRepository extends JpaRepository<WaitingInformation, Long> {
    Optional<WaitingInformation> findByShopId(Long shopId);
}
