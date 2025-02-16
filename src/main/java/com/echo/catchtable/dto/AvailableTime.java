package com.echo.catchtable.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AvailableTime (
        String startTime,
        String endTime
) {

}
