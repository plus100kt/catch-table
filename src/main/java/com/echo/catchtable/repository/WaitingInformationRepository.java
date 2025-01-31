package com.echo.catchtable.repository;

import com.echo.catchtable.domain.WaitingInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaitingInformationRepository extends JpaRepository<WaitingInformation, Long> {

}
