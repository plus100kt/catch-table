package com.echo.catchtable.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WaitingInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "shop_id", nullable = false)
    private Long shopId;

    @Column(name = "waiting_max_count", nullable = false)
    private Integer waitingMaxCount;

    @Column(name = "expected_time_per_person", nullable = false)
    private Integer expectedTimePerPerson;

    @Column(name = "status", nullable = false)
    private String status;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Builder
    public WaitingInformation(
            long shopId,
            int waitingMaxCount,
            int expectedTimePerPerson,
            String status
    ) {
        this.shopId = shopId;
        this.waitingMaxCount = waitingMaxCount;
        this.expectedTimePerPerson = expectedTimePerPerson;
        this.status = status;
    }
}
