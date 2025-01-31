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
public class ReservationInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "shop_id", nullable = false)
    private Long shop_id;

    @Column(name = "period", nullable = false)
    private Integer period;

    @Lob
    @Column(name = "available_times", nullable = false)
    private String available_times;

    @Column(name = "status", nullable = false)
    private String status;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Builder
    public ReservationInformation(
            long shop_id,
            int period,
            String reservation_available_times,
            String status
    ) {
        this.shop_id = shop_id;
        this.period = period;
        this.available_times = reservation_available_times;
        this.status = status;
    }
}
