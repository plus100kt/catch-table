package com.echo.catchtable.repository;

import com.echo.catchtable.domain.ReservationInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationInformationRepository extends JpaRepository<ReservationInformation, Long> {

}
