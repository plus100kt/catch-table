package com.echo.catchtable.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
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
    private Long shop_id;

    @Column(name = "waiting_max_count", nullable = false)
    private Integer waiting_max_count;

    @Column(name = "expected_time_per_person", nullable = false)
    private Integer expected_time_per_person;

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
            long shop_id,
            int waiting_max_count,
            int expected_time_per_person,
            String status
    ) {
        this.shop_id = shop_id;
        this.waiting_max_count = waiting_max_count;
        this.expected_time_per_person = expected_time_per_person;
        this.status = status;
    }
}
