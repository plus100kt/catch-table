package com.echo.catchtable.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AvailableTime (
        String start_time,
        String end_time
) {

}
