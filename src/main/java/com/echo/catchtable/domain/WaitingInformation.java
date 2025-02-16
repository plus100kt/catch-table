package com.echo.catchtable.domain;

import com.echo.catchtable.enums.WaitingStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WaitingInformation extends BaseEntity {
    @Column(name = "shop_id", nullable = false)
    private Long shopId;

    @Column(name = "waiting_max_count", nullable = false)
    private Integer waitingMaxCount;

    @Column(name = "expected_time_per_person", nullable = false)
    private Integer expectedTimePerPerson;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private WaitingStatus status;

    @Builder
    public WaitingInformation(
            long shopId,
            int waitingMaxCount,
            int expectedTimePerPerson,
            WaitingStatus status
    ) {
        this.shopId = shopId;
        this.waitingMaxCount = waitingMaxCount;
        this.expectedTimePerPerson = expectedTimePerPerson;
        this.status = status;
    }
}
