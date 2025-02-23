package com.echo.catchtable.domain;

import com.echo.catchtable.dto.AvailableTime;
import com.echo.catchtable.enums.ReservationStatus;
import com.echo.catchtable.utils.AvailableTimesConverter;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationInformation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "shop_id", nullable = false)
    private Long shopId;

    @Column(name = "period", nullable = false)
    private Integer period;

    @Lob
    @Column(name = "available_times", nullable = false)
    @Convert(converter = AvailableTimesConverter.class)
    private List<AvailableTime> availableTimes;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

    @Builder
    public ReservationInformation(
            long shopId,
            int period,
            List<AvailableTime> availableTimes,
            ReservationStatus status
    ) {
        this.shopId = shopId;
        this.period = period;
        this.availableTimes = availableTimes;
        this.status = status;
    }
}
