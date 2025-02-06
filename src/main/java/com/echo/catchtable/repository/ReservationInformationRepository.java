package com.echo.catchtable.repository;

import com.echo.catchtable.domain.ReservationInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationInformationRepository extends JpaRepository<ReservationInformation, Long> {
    Optional<ReservationInformation> findByShopId(Long shopId);
}
