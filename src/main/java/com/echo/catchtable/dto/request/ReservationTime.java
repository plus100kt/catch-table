package com.echo.catchtable.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ReservationTime (
        String start_time,
        String end_time
) {

}
