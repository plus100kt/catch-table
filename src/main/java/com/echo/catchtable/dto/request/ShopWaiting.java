package com.echo.catchtable.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ShopWaiting (
        int waiting_max_count,
        int expected_time_per_person
){

}
